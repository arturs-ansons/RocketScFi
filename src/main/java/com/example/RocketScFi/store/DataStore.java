package com.example.RocketScFi.store;

import com.example.RocketScFi.model.Person;
import com.example.RocketScFi.model.Crew;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class DataStore {

    public static final List<Person> persons = new ArrayList<>();
    public static final List<Crew> crews = new ArrayList<>();

    public static final AtomicLong personCounter = new AtomicLong();
    public static final AtomicLong crewCounter = new AtomicLong();
}