package com.example.battleships.services;

import com.example.battleships.models.entities.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUserById(long id);
}
