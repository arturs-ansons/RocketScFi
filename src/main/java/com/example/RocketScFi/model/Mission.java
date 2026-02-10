package com.example.RocketScFi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Mission {
    private long id;
    private String launchDate;
    private String launchSite;
    private String landingDevice;
    private long crew;
    private long spaceCraft;
}
