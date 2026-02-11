package com.example.RocketScFi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity
public class Person {
    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
}
