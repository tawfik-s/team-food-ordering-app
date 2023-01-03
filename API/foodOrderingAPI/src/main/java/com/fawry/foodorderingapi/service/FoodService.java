package com.fawry.foodorderingapi.service;

import com.fawry.foodorderingapi.entity.Food;
import com.fawry.foodorderingapi.model.FoodDto;
import com.fawry.foodorderingapi.model.RestaurantDto;

import java.util.List;

public interface FoodService {

    public Food addFood(Long restaurantId, FoodDto foodDto);

    public List<Food> getAll();

    public Food getFoodById(Long id);

    public void updateFood(Long id, FoodDto foodDto);

    public void deleteFood(Long id);

}
