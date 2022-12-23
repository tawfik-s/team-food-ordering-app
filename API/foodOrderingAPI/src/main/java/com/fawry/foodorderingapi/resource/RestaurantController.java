package com.fawry.foodorderingapi.resource;

import com.fawry.foodorderingapi.entity.Restaurant;
import com.fawry.foodorderingapi.mapper.RestaurantMapper;
import com.fawry.foodorderingapi.model.RestaurantDto;
import com.fawry.foodorderingapi.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<?> addRestaurant(@RequestBody RestaurantDto restaurantDto){
        Restaurant restaurant = RestaurantMapper.INSTANCE.mapToRestaurant(restaurantDto);
        return ResponseEntity.ok().body(restaurantService.addRestaurant(restaurant));
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(restaurantService.getAll());
    }

    @GetMapping("byId/{id}")
    public ResponseEntity<?> getRestaurantById(@PathVariable Long id){
        return ResponseEntity.ok().body(restaurantService.getRestaurantById(id));
    }

    @GetMapping("byName/{name}")
    public ResponseEntity<?> getRestaurantByName(@PathVariable String name){
        return ResponseEntity.ok().body(restaurantService.getRestaurantByName(name));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deleteRestaurant(@PathVariable Long id){
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.ok().build();
    }
}
