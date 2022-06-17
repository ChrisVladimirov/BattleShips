package com.example.battleships.services.impl;

import com.example.battleships.models.entities.Category;
import com.example.battleships.models.enums.ShipType;
import com.example.battleships.repositories.CategoryRepository;
import com.example.battleships.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() != 0) {
            return;
        }
        Arrays.stream(ShipType.values()).forEach(categoryEnum -> {
            Category category = new Category();
            switch (categoryEnum) {
                case CARGO:
                    category.setName(ShipType.valueOf("CARGO"));
                case BATTLE:
                    category.setName(ShipType.valueOf("BATTLE"));
                case PATROL:
                    category.setName(ShipType.valueOf("PATROL"));
            }
            this.categoryRepository.save(category);
        });
    }
}
