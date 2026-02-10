package com.example.RocketScFi.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Spacecraft {
    private long id;
    private String name;
    private double mass;
    private String manufacturer;
}
