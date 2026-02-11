package com.example.RocketScFi.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class Person {
    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    @ManyToOne
    private Crew crew;
}
