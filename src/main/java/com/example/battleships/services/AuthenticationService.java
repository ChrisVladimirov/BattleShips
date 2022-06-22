package com.example.battleships.services;

import com.example.battleships.models.DTOs.dataImport.UserLoginDTO;
import com.example.battleships.models.DTOs.dataImport.UserRegisterDTO;

public interface AuthenticationService {

    boolean register(UserRegisterDTO userRegisterDTO);

    boolean login(UserLoginDTO loginDTO);

    void logout();
}
