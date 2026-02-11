package com.example.RocketScFi.service;

import com.example.RocketScFi.dto.SpacecraftDTO;
import com.example.RocketScFi.dto.SpacecraftResponse;
import com.example.RocketScFi.model.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SpacecraftService {
    private final SpacecraftRepository spacecraftRepository;

    public SpacecraftService(SpacecraftRepository spacecraftRepository) {
        this.spacecraftRepository = spacecraftRepository;
    }

    public boolean save(SpacecraftDTO spacecraftDTO) {
        Spacecraft spacecraft = new Spacecraft();
        spacecraft.setName(spacecraftDTO.getName());
        spacecraft.setMass(spacecraftDTO.getMass());
        spacecraft.setManufacturer(spacecraftDTO.getManufacturer());
        spacecraftRepository.save(spacecraft);
        return true;
    }

    public Optional<SpacecraftResponse> findById(long id) {
        Optional<Spacecraft> spacecraftOptional = spacecraftRepository.findById(id);
        if (spacecraftOptional.isEmpty()) {
            return Optional.empty();
        }
        Spacecraft spacecraft = spacecraftOptional.get();
        SpacecraftResponse spacecraftResponse = new SpacecraftResponse(
                spacecraft.getId(),
                spacecraft.getName(),
                spacecraft.getMass(),
                spacecraft.getManufacturer()
        );
        return Optional.of(spacecraftResponse);
    }

    public List<SpacecraftResponse> findAll() {
        return spacecraftRepository
                .findAll()
                .stream()
                .map(e -> new SpacecraftResponse(e.getId(), e.getName(), e.getMass(), e.getManufacturer()))
                .toList();
    }

}
