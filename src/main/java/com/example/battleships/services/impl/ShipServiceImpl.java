package com.example.battleships.services.impl;

import com.example.battleships.models.DTOs.CreateShipDTO;
import com.example.battleships.models.entities.Ship;
import com.example.battleships.repositories.ShipRepository;
import com.example.battleships.services.CategoryService;
import com.example.battleships.services.ShipService;
import com.example.battleships.services.UserService;
import com.example.battleships.session.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipServiceImpl implements ShipService {
    private final ShipRepository shipRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;
    private final UserService userService;
    private final LoggedUser loggedUser;

    @Autowired
    public ShipServiceImpl(ShipRepository shipRepository, ModelMapper modelMapper, CategoryService categoryService, UserService userService, LoggedUser loggedUser) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
        this.userService = userService;
        this.loggedUser = loggedUser;
    }

    @Override
    public void addShip(CreateShipDTO createShipDTO) {
        Ship mappedShip = this.modelMapper.map(createShipDTO, Ship.class);
        mappedShip.setCategory(this.categoryService.getCategory(createShipDTO.getCategory()));
        mappedShip.setUser(this.userService.getUserById(this.loggedUser.getId()));
        this.shipRepository.save(mappedShip);
    }
}
