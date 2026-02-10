package com.example.RocketScFi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Spacecraft {
    private long id;
    private String name;
    private double mass;
    private String manufacturer;
}
