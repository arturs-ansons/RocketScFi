package com.example.RocketScFi.model;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class Crew {
    private long id;
    private List<Long> people;
}
