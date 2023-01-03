package com.fawry.foodorderingapi.service.impl;

import com.fawry.foodorderingapi.entity.Food;
import com.fawry.foodorderingapi.entity.Restaurant;
import com.fawry.foodorderingapi.exception.RecordNotFoundException;
import com.fawry.foodorderingapi.mapper.FoodMapper;
import com.fawry.foodorderingapi.model.FoodDto;
import com.fawry.foodorderingapi.repository.FoodRepo;
import com.fawry.foodorderingapi.repository.RestaurantRepo;
import com.fawry.foodorderingapi.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodRepo foodRepo;
    @Autowired
    private RestaurantRepo restaurantRepo;
    @Autowired
    private FoodMapper foodMapper;

    @Override
    public Food addFood(Long restaurantId, FoodDto foodDto) {
        Food food = foodMapper.toEntity(foodDto);
        food = foodRepo.save(food);
        Restaurant restaurant= restaurantRepo
                .findById(restaurantId)
                .orElseThrow(RecordNotFoundException::new);
        restaurant.getFoods().add(food);
        restaurantRepo.save(restaurant);
        return food;
    }

    @Override
    public List<Food> getAll() {
        return foodRepo.findAll();
    }

    @Override
    public Food getFoodById(Long id) {
        return foodRepo.findById(id).orElseThrow(RecordNotFoundException::new);
    }

    @Override
    public void updateFood(Long id, FoodDto foodDto) {
        Food food = foodRepo
                .findById(id)
                .orElseThrow(RecordNotFoundException::new);
        foodMapper.updateFoodFromDto(foodDto, food);
           foodRepo.save(food);
    }

    @Override
    public void deleteFood(Long id) {
        foodRepo.deleteById(id);
    }
}