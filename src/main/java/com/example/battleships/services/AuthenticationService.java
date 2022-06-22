package com.example.battleships.services;

import com.example.battleships.models.DTOs.UserLoginDTO;
import com.example.battleships.models.DTOs.UserRegisterDTO;

public interface AuthenticationService {

    boolean register(UserRegisterDTO userRegisterDTO);

    boolean login(UserLoginDTO loginDTO);

    void logout();
}
