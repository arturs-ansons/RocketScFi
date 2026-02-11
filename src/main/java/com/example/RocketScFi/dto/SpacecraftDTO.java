package com.example.RocketScFi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpacecraftDTO {
    private String name;
    private double mass;
    private String manufacturer;
}
