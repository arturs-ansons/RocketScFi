package com.example.RocketScFi.service;

import com.example.RocketScFi.dto.SpacecraftDTO;
import com.example.RocketScFi.dto.SpacecraftResponse;
import com.example.RocketScFi.model.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SpacecraftService {
    private final SpacecraftRepository spacecraftRepository;
    SortedMap<Long, Spacecraft> spacecrafts = new TreeMap<>();
    SortedMap<Long, Person> people = new TreeMap<>();
    SortedMap<Long, Crew> crews = new TreeMap<>();
    SortedMap<Long, Mission> missions = new TreeMap<>();

    public SpacecraftService(SpacecraftRepository spacecraftRepository) {
        this.spacecraftRepository = spacecraftRepository;
    }

    public void save(SpacecraftDTO spacecraftDTO) {
        Spacecraft spacecraft = new Spacecraft();
        spacecraft.setId(spacecraftDTO.getId());
        spacecraft.setName(spacecraftDTO.getName());
        spacecraft.setMass(spacecraftDTO.getMass());
        spacecraft.setManufacturer(spacecraftDTO.getManufacturer());
        spacecraftRepository.save(spacecraft);
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

    public void savePerson(String firstName, String lastName) {
        long id = getLastKey(people);
        Person person = new Person(id, firstName, lastName);
        people.put(id, person);
    }

    public Optional<Person> findPersonById(long id) {
        return Optional.ofNullable(people.get(id));
    }

    public Collection<Person> findAllPeople() {
        return people.values();
    }

    public void saveCrew(List<Long> members) {
        long id = getLastKey(crews);
        Crew crew = new Crew(id, members);
        crews.put(id, crew);
    }

    public Optional<Crew> findCrewById(long id) {
        return Optional.ofNullable(crews.get(id));
    }

    public Collection<Crew> findAllCrews() {
        return crews.values();
    }

    public void saveMission(String launchDate, String launchSite, String landingDevice, long crew, long spaceCraft) {
        long id = getLastKey(missions);
        Mission mission = new Mission(id, launchDate, launchSite, landingDevice, crew, spaceCraft);
        missions.put(id, mission);
    }

    public Optional<Mission> findMissionById(long id) {
        return Optional.ofNullable(missions.get(id));
    }

    public Collection<Mission> findAllMissions() {
        return missions.values();
    }

    private long getLastKey(SortedMap<Long, ?> map) {
        long key;
        try {
            key = map.lastKey() + 1;
        } catch (NoSuchElementException e) {
            key = 0;
        }
        return key;
    }
}
