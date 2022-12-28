package com.fawry.foodorderingapi.service;

import com.fawry.foodorderingapi.entity.Restaurant;
import com.fawry.foodorderingapi.model.RestaurantDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestaurantService {
   public Restaurant addRestaurant(RestaurantDto restaurantDto);
   public List<Restaurant> getAll();
   public Restaurant getRestaurantById(Long id);
   public Restaurant getRestaurantByName(String name);
   public void deleteRestaurant(Long id);
}
