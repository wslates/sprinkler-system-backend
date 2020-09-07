package io.slates.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;

public class Zone {
    @Id
    private String id;

    @Indexed(unique = true)
    private String name;
    @Indexed(unique = true)
    private Integer gpio;
    private Double area;
    @Transient
    private Boolean status;

    public Zone() {

    }

    public Zone(String name, Integer gpio, Double area) {
        this.name = name;
        this.area = area;
        this.gpio = gpio;
        status = false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getGpio() {
        return gpio;
    }

    public void setGpio(Integer gpio) {
        this.gpio = gpio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
