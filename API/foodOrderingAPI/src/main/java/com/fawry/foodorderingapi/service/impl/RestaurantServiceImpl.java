package com.fawry.foodorderingapi.service.impl;

import com.fawry.foodorderingapi.entity.Restaurant;
import com.fawry.foodorderingapi.exception.RecordNotFoundException;
import com.fawry.foodorderingapi.repository.RestaurantRepo;
import com.fawry.foodorderingapi.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantRepo restaurantRepo;
    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
      return  restaurantRepo.save(restaurant);
    }

    @Override
    public List<Restaurant> getAll() {
        return restaurantRepo.findAll();
    }

    @Override
    public Restaurant getRestaurantById(Long id) {
        return restaurantRepo.findById(id).orElseThrow(()->new RecordNotFoundException("can't find restaurant record"));
    }

    @Override
    public Restaurant getRestaurantByName(String name) {
        return restaurantRepo.findByName(name);
    }

    @Override
    public void deleteRestaurant(Long id) {
        restaurantRepo.deleteById(id);
    }

}
