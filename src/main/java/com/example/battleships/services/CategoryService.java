package com.example.battleships.services;

import com.example.battleships.models.entities.Category;
import com.example.battleships.models.enums.ShipType;

public interface CategoryService {

    void initCategories();

    Category getCategory(ShipType categoryName);
}
