package com.example.RocketScFi.service;

import com.example.RocketScFi.model.Crew;
import com.example.RocketScFi.model.Mission;
import com.example.RocketScFi.model.Person;
import com.example.RocketScFi.model.Spacecraft;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RocketService {
    SortedMap<Long, Spacecraft> spacecrafts = new TreeMap<>();
    SortedMap<Long, Person> people = new TreeMap<>();
    SortedMap<Long, Crew> crews = new TreeMap<>();
    SortedMap<Long, Mission> missions = new TreeMap<>();

    public void saveSpacecraft(String name, double mass, String manufacturer) {
        long id = getLastKey(spacecrafts);
        Spacecraft spacecraft = new Spacecraft(id, name, mass, manufacturer);
        spacecraft.setId(id);
        spacecraft.setName(name);
        spacecraft.setMass(mass);
        spacecraft.setManufacturer(manufacturer);
        spacecrafts.put(id, spacecraft);
    }

    public Optional<Spacecraft> findSpacecraftById(long id) {
        return Optional.ofNullable(spacecrafts.get(id));
    }

    public Collection<Spacecraft> findAllSpacecrafts() {
        return spacecrafts.values();
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
