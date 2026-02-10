package com.example.RocketScFi.model;

import java.util.List;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Crew {
    private long id;
    private List<Long> people;
}
