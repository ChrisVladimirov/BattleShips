package com.example.battleships.services.impl;

import com.example.battleships.models.entities.User;
import com.example.battleships.repositories.UserRepository;
import com.example.battleships.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getUserById(long id) {
        return this.userRepository.findById(id);
    }
}
