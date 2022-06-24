package com.example.battleships.repositories;

import com.example.battleships.models.entities.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {

    Optional<Ship> findByName(String name);

    Ship getByName(String name);

    List<Ship> findByOrderByNameAscHealthAscPowersAsc();

    List<Ship> getByUser_Id(Long id);

    List<Ship> getByUser_IdNot(Long id);
}
