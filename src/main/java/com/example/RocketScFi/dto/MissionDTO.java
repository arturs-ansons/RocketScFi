package com.example.RocketScFi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissionDTO {
    private String launchDate;
    private String launchSite;
    private String landingDevice;
    private long crew;
    private long spacecraft;
}
