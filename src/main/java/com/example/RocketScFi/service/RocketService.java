package com.example.RocketScFi.service;

import com.example.RocketScFi.model.Spacecraft;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RocketService {
    SortedMap<Long, Spacecraft> spacecrafts = new TreeMap<>();

    public void save(String name, double mass, String manufacturer) {
        Spacecraft spacecraft = new Spacecraft();
        long id;
        try {
            id = spacecrafts.lastKey() + 1;
        } catch (NoSuchElementException e) {
            id = 0;
        }
        spacecraft.setId(id);
        spacecraft.setName(name);
        spacecraft.setMass(mass);
        spacecraft.setManufacturer(manufacturer);
        spacecrafts.put(id, spacecraft);
    }

    public Optional<Spacecraft> findSpacecraftById(long id) {
        return Optional.ofNullable(spacecrafts.get(id));
    }

    public Collection<Spacecraft> findAll() {
        return spacecrafts.values();
    }
}
