package com.fawry.foodorderingapi.service.impl;

import com.fawry.foodorderingapi.entity.Food;
import com.fawry.foodorderingapi.exception.ItemNotAvailableException;
import com.fawry.foodorderingapi.repository.FoodRepo;
import com.fawry.foodorderingapi.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodRepo foodRepo;


    @Override
    public Food addFood(Food food) {
        return foodRepo.save(food);
    }

    @Override
    public List<Food> getAll() {
        return foodRepo.findAll();
    }

    @Override
    public Food getFoodById(Long id) {
        return foodRepo.findById(id);
    }

    @Override
    public Food updateFood(Food food) {
        Food food1 = foodRepo.findById(food.getId()).orElseThrow(() -> {
            return new ItemNotAvailableException("");
        });
        food1.setId(food.getId());
        food1.setName(food.getName());
        food1.setPrice(food.getPrice());
        food1.setImage(food.getImage());

        return foodRepo.save(food1);
    }

    @Override
    public void deleteFood(Long id) {
        foodRepo.deleteById(id);
    }
}
