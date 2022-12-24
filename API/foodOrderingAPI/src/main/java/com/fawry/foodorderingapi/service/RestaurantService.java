package com.fawry.foodorderingapi.service;

import com.fawry.foodorderingapi.entity.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestaurantService {
   public Restaurant addRestaurant(Restaurant restaurant);
   public List<Restaurant> getAll();
   public Restaurant getRestaurantById(Long id);
   public Restaurant getRestaurantByName(String name);
   public void deleteRestaurant(Long id);
}
