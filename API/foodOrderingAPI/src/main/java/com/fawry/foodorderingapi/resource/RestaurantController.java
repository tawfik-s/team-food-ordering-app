package com.fawry.foodorderingapi.resource;

import com.fawry.foodorderingapi.entity.Restaurant;
import com.fawry.foodorderingapi.mapper.RestaurantMapper;
import com.fawry.foodorderingapi.model.RestaurantDto;
import com.fawry.foodorderingapi.service.RestaurantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

@RestController
@RequestMapping("restaurants")
@Slf4j
@Validated
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<?> addRestaurant(@RequestBody RestaurantDto restaurantDto){
        log.info("add restaurant={} to database", restaurantDto);
        Restaurant restaurant = RestaurantMapper.INSTANCE.mapToRestaurant(restaurantDto);
        return ResponseEntity.ok().body(restaurantService.addRestaurant(restaurant));
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        log.info("get all restaurants from database");
        return ResponseEntity.ok().body(restaurantService.getAll());
    }

    @GetMapping("byId/{id}")
    public ResponseEntity<?> getRestaurantById(@PathVariable @Min(value = 1, message = "enter valid number") Long id){
        log.info("get restaurant with id={} from database", id);
        return ResponseEntity.ok().body(restaurantService.getRestaurantById(id));
    }

    @GetMapping("byName/{name}")
    public ResponseEntity<?> getRestaurantByName(@PathVariable String name){
        log.info("get restaurant with name={} from database", name);
        return ResponseEntity.ok().body(restaurantService.getRestaurantByName(name));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deleteRestaurant(@PathVariable @Min(value = 1, message = "Element Not Found") Long id){
        log.info("delete restaurant with id={} from database", id);
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.noContent().build();
    }
}
