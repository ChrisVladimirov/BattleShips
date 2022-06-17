package com.example.battleships.models.entities;

import com.example.battleships.models.enums.ShipType;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private ShipType name;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String description;

    public Category() {
    }
    public Category(ShipType type) {
        this.name = type;
    }

    public long getId() {
        return id;
    }

    public ShipType getName() {
        return name;
    }

    public Category setName(ShipType name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }
}
