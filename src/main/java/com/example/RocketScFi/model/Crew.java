package com.example.RocketScFi.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class Crew {
    @Id @GeneratedValue
    private long id;
    @OneToMany(mappedBy = "crew")
    private List<Person> people;
}
