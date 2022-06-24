package com.example.battleships.services.impl;

import com.example.battleships.models.DTOs.dataImport.CreateShipDTO;
import com.example.battleships.models.DTOs.dataExport.ShipViewDTO;
import com.example.battleships.models.entities.Ship;
import com.example.battleships.models.entities.User;
import com.example.battleships.repositories.ShipRepository;
import com.example.battleships.services.CategoryService;
import com.example.battleships.services.ShipService;
import com.example.battleships.services.UserService;
import com.example.battleships.session.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public boolean addShip(CreateShipDTO createShipDTO) {
        Optional<Ship> optionalShip = this.shipRepository.findByName(createShipDTO.getName());
        if (optionalShip.isPresent()) {
            return false;
        }

        Ship mappedShip = this.modelMapper.map(createShipDTO, Ship.class);
        mappedShip.setCategory(this.categoryService.getCategory(createShipDTO.getCategory()));

        Optional<User> owner = this.userService.getUserById(this.loggedUser.getId());
        mappedShip.setUser(owner.get());

        this.shipRepository.save(mappedShip);

        return true;
    }

    @Override
    public void attack(String attacker, String defender) {
        Ship attackerShip = this.shipRepository.getByName(attacker);
        Ship defenderShip = this.shipRepository.getByName(defender);

        long defenderHealth = defenderShip.getHealth() - attackerShip.getPower();
        if (defenderHealth <= 0) {
            shipRepository.delete(defenderShip);
            return;
        }
        defenderShip.setHealth(defenderHealth);
        shipRepository.save(defenderShip);
    }

    @Override
    public List<ShipViewDTO> visualiseAll() {
        return this.shipRepository.findByOrderByNameAscHealthAscPowersAsc().stream()
                .map(ship -> this.modelMapper.map(ship, ShipViewDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShipViewDTO> getOwnShipsOrdered(Long id) {
        return this.shipRepository.getByUser_Id(id).stream()
                .map(ship -> this.modelMapper.map(ship, ShipViewDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShipViewDTO> getOtherShipsOrdered(Long id) {
        return this.shipRepository.getByUser_IdNot(id).stream()
                .map(ship -> this.modelMapper.map(ship, ShipViewDTO.class))
                .collect(Collectors.toList());
    }
}
