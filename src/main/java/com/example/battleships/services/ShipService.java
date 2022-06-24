package com.example.battleships.services;

import com.example.battleships.models.DTOs.dataImport.CreateShipDTO;
import com.example.battleships.models.DTOs.dataExport.ShipViewDTO;

import java.util.List;

public interface ShipService {

    boolean addShip(CreateShipDTO createShipDTO);

    void attack(String attacker, String defender);

    List<ShipViewDTO> visualiseAll();

    List<ShipViewDTO> getOwnShipsOrdered(Long id);

    List<ShipViewDTO> getOtherShipsOrdered(Long id);
}
