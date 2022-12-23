package com.fawry.foodorderingapi.service.serviceImlementation;

import com.fawry.foodorderingapi.entity.Restaurant;
import com.fawry.foodorderingapi.repository.RestaurantRepo;
import com.fawry.foodorderingapi.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Restaurant> getRestaurantById(Long id) {
        return restaurantRepo.findById(id);
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
