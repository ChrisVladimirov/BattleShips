package com.example.battleships.services;

import com.example.battleships.models.DTOs.CreateShipDTO;

public interface ShipService {

    void addShip(CreateShipDTO createShipDTO);
}
