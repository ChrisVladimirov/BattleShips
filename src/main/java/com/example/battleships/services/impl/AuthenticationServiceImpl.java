package com.example.battleships.services.impl;

import com.example.battleships.models.DTOs.dataImport.UserLoginDTO;
import com.example.battleships.models.DTOs.dataImport.UserRegisterDTO;
import com.example.battleships.models.entities.User;
import com.example.battleships.repositories.UserRepository;
import com.example.battleships.services.AuthenticationService;
import com.example.battleships.session.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    private final LoggedUser userSession;

    private final PasswordEncoder encoder;

    @Autowired
    public AuthenticationServiceImpl(UserRepository userRepository, ModelMapper mapper,
                                     LoggedUser userSession, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.userSession = userSession;
        this.encoder = encoder;
    }

    @Override
    public boolean register(UserRegisterDTO userRegisterDTO) {
        if (!userRegisterDTO.getPassword().equals(userRegisterDTO.getConfirmPassword())) {
            return false;
        }

        Optional<User> byEmail = this.userRepository.findByEmail(userRegisterDTO.getEmail());
        if (byEmail.isPresent()) {
            return false;
        }

        Optional<User> byUsername = this.userRepository.findByUsername(userRegisterDTO.getUsername());
        if (byUsername.isPresent()) {
            return false;
        }

        User user = this.mapper.map(userRegisterDTO, User.class);
        user.setPassword(encoder.encode(userRegisterDTO.getPassword()));
        this.userRepository.save(user);
        return true;
    }

    @Override
    public boolean login(UserLoginDTO loginDTO) {
        Optional<User> byUsername = this.userRepository
                .findByUsername(loginDTO.getUsername());
        if (byUsername.isEmpty()) {
            return false;
        }

        this.userSession.login(byUsername.get());
        return true;
    }

    @Override
    public void logout() {
        this.userSession.logout();
    }
}
