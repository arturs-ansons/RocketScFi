package com.example.RocketScFi.model;

import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class Crew {
    private long id;
    private Map<Long, Person> people;
}
