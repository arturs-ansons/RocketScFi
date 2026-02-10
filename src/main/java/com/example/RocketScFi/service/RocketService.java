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


    public Spacecraft createSpacecraft(String name, double mass, String manufacturer) {
        Spacecraft spacecraft = new Spacecraft();
        long id;
        try {
            id = spacecrafts.lastKey() + 1;
        } catch(NoSuchElementException e) {
            id = 0;
        }
        spacecraft.setId(id);
        spacecraft.setName(name);
        spacecraft.setMass(mass);
        spacecraft.setManufacturer(manufacturer);
        return spacecrafts.put(id, spacecraft);
    }

    public Spacecraft getSpacecrafts(long id) {
        return spacecrafts.get(id);
    };

    public Collection<Spacecraft> getSpacecrafts() {
        return spacecrafts.values();
    };
}
