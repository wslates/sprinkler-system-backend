package io.slates.model;

import org.springframework.data.annotation.Id;

import java.util.List;

public class SprinklerProgram {
    @Id
    private String id;
    private List<Zone> zones;
    private String day;
    private String time;

    public SprinklerProgram(List<Zone> zones, String day, String time) {
        this.zones = zones;
        this.day = day;
        this.time = time;
    }

    public SprinklerProgram() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Zone> getZones() {
        return zones;
    }

    public void setZones(List<Zone> zones) {
        this.zones = zones;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
