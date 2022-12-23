package com.fawry.foodorderingapi.service;

import com.fawry.foodorderingapi.entity.Food;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface FoodService {

    public Food addFood(Food food);
    public List<Food> getAll();
    public Optional<Food> getFoodById(Long id);
    public Food updateFood(Food food);
    public void deleteFood(Long id);

}
