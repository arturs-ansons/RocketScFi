package com.example.RocketScFi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity
public class Spacecraft {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private double mass;
    private String manufacturer;
}
