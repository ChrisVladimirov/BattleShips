package com.example.battleships.models.DTOs.dataExport;

public class ShipViewDTO {
    private String name;

    private long health;

    private long power;

    public ShipViewDTO() {
    }

    public String getName() {
        return name;
    }

    public ShipViewDTO setName(String name) {
        this.name = name;
        return this;
    }

    public long getHealth() {
        return health;
    }

    public ShipViewDTO setHealth(long health) {
        this.health = health;
        return this;
    }

    public long getPower() {
        return power;
    }

    public ShipViewDTO setPower(long power) {
        this.power = power;
        return this;
    }
}
