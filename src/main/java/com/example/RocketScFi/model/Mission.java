package com.example.RocketScFi.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mission {
    private long id;
    private String launchDate;
    private String launchSite;
    private String landingDevice;
    private long crew;
    private long spaceCraft;
}
