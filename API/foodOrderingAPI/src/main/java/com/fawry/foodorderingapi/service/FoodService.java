package com.fawry.foodorderingapi.service;

import com.fawry.foodorderingapi.entity.Food;

import java.util.List;

public interface FoodService {

    public Food addFood(Food food);

    public List<Food> getAll();

    public Food getFoodById(Long id);

    public Food updateFood(Food food);

    public void deleteFood(Long id);

}
