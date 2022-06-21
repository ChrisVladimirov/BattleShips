package com.example.battleships.models.DTOs;

import com.example.battleships.models.entities.Category;
import com.example.battleships.models.enums.ShipType;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class CreateShipDTO {

    @NotBlank
    @Size(min = 2, max = 10)
    private String name;

    @Positive
    private long power;

    @Positive
    private long health;

    @Future
    private LocalDate created;

    @NotNull
    private ShipType category;

    public String getName() {
        return name;
    }

    public CreateShipDTO setName(String name) {
        this.name = name;
        return this;
    }

    public long getPower() {
        return power;
    }

    public CreateShipDTO setPower(long power) {
        this.power = power;
        return this;
    }

    public long getHealth() {
        return health;
    }

    public CreateShipDTO setHealth(long health) {
        this.health = health;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public CreateShipDTO setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public ShipType getCategory() {
        return category;
    }

    public CreateShipDTO setCategory(ShipType category) {
        this.category = category;
        return this;
    }
}