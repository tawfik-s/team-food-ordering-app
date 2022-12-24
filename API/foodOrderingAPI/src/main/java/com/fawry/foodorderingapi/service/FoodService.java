package com.fawry.foodorderingapi.service;

import com.fawry.foodorderingapi.entity.Food;
import com.fawry.foodorderingapi.models.FoodCreationDto;

import java.util.List;

public interface FoodService {

    public Food addProduct(Food food);

    public List<Food> getAllFood();

    public Food getFoodById(Long id);

}