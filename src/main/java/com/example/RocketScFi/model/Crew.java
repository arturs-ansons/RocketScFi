package com.example.RocketScFi.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity
public class Crew {
    @Id @GeneratedValue
    private long id;
    private List<Long> people;
}
