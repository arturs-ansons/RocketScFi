package com.example.RocketScFi.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class Crew {
    private long id;
    private List<Long> people;
}
