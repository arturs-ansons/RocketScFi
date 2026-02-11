package com.example.RocketScFi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity
public class Mission {
    @Id @GeneratedValue
    private long id;
    private String launchDate;
    private String launchSite;
    private String landingDevice;
    private long crew;
    private long spacecraft;
}
