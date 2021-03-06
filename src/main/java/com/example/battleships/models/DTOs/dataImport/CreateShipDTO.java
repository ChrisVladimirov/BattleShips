package com.example.battleships.models.DTOs.dataImport;

import com.example.battleships.models.enums.ShipType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class CreateShipDTO {

    @NotBlank
    @Size(min = 2, max = 10)
    private String name;

    @Positive
    private long powers;

    @Positive
    private long health;

    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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

    public long getPowers() {
        return powers;
    }

    public CreateShipDTO setPowers(long powers) {
        this.powers = powers;
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
