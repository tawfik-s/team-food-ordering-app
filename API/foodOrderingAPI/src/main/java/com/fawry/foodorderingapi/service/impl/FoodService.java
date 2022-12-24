package com.fawry.foodorderingapi.service.impl;

import com.fawry.foodorderingapi.entity.Food;
import com.fawry.foodorderingapi.models.FoodCreationDto;
import com.fawry.foodorderingapi.repository.FoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService implements com.fawry.foodorderingapi.service.FoodService{
    @Autowired
    private FoodRepo foodRepo;

    @Override
    public Food addProduct(Food food) {
        return foodRepo.save(food);
    }

    @Override
    public List<Food> getAllFood() {
        return foodRepo.findAll();
    }

    @Override
    public Food getFoodById(Long id) {
        return foodRepo.findById(id).orElse(null);
    }
}
