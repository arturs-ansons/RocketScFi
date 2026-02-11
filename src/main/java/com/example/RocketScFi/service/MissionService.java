package com.example.RocketScFi.service;

import com.example.RocketScFi.dto.MissionDTO;
import com.example.RocketScFi.dto.MissionResponse;
import com.example.RocketScFi.model.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissionService {
    private final CrewService crewService;
    private final SpacecraftService spacecraftService;
    private final MissionRepository missionRepository;

    public MissionService(CrewService crewService, SpacecraftService spacecraftService, MissionRepository missionRepository) {
        this.crewService = crewService;
        this.spacecraftService = spacecraftService;
        this.missionRepository = missionRepository;
    }

    public boolean save(MissionDTO missionDTO) {
        if (crewService.findById(missionDTO.getCrew()).isEmpty()) {
            return false;
        }

        if (spacecraftService.findById(missionDTO.getSpacecraft()).isEmpty()) {
            return false;
        }

        Mission mission = new Mission();
        mission.setLaunchDate(missionDTO.getLaunchDate());
        mission.setLaunchSite(missionDTO.getLaunchSite());
        mission.setLandingDevice(missionDTO.getLandingDevice());
        mission.setCrew(missionDTO.getCrew());
        mission.setSpacecraft(missionDTO.getSpacecraft());
        missionRepository.save(mission);
        return true;
    }

    public boolean deleteById(long id) {
        if (findById(id).isEmpty()) {
            return false;
        }

        missionRepository.deleteById(id);
        return true;
    }


    public Optional<MissionResponse> findById(long id) {
        Optional<Mission> missionOptional = missionRepository.findById(id);
        if (missionOptional.isEmpty()) {
            return Optional.empty();
        }
        Mission mission = missionOptional.get();
        MissionResponse missionResponse = new MissionResponse(
                mission.getId(),
                mission.getLaunchDate(),
                mission.getLaunchSite(),
                mission.getLandingDevice(),
                mission.getCrew(),
                mission.getSpacecraft()
        );
        return Optional.of(missionResponse);
    }

    public List<MissionResponse> findAll() {
        return missionRepository
                .findAll()
                .stream()
                .map(e -> new MissionResponse(
                        e.getId(),
                        e.getLaunchDate(),
                        e.getLaunchSite(),
                        e.getLandingDevice(),
                        e.getCrew(),
                        e.getSpacecraft()
                ))
                .toList();
    }
}
