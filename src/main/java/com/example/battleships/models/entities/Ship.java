package com.example.battleships.models.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ships")
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private long health;

    @Column(nullable = false)
    private long powers;

    @Column(nullable = false)
    private LocalDate created;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;

    public Ship() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Ship setName(String name) {
        this.name = name;
        return this;
    }

    public long getHealth() {
        return health;
    }

    public Ship setHealth(long health) {
        this.health = health;
        return this;
    }

    public long getPowers() {
        return powers;
    }

    public Ship setPowers(long powers) {
        this.powers = powers;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public Ship setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Ship setCategory(Category category) {
        this.category = category;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Ship setUser(User owner) {
        this.user = owner;
        return this;
    }
}
