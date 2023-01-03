package com.fawry.foodorderingapi.resources;

import com.fawry.foodorderingapi.entity.Restaurant;
import com.fawry.foodorderingapi.mapper.RestaurantMapper;
import com.fawry.foodorderingapi.model.RestaurantDto;
import com.fawry.foodorderingapi.service.RestaurantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("restaurants")
@Slf4j
@Validated
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurant addRestaurant(@RequestBody RestaurantDto restaurantDto){
        log.info("add restaurant={} to database", restaurantDto);
        return restaurantService.addRestaurant(restaurantDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Restaurant> getAll(){
        log.info("get all restaurants from database");
        return restaurantService.getAll();
    }

    @GetMapping("/{id}/get")
    @ResponseStatus(HttpStatus.OK)
    public Restaurant getRestaurantById(@RequestParam @Min(value = 1, message = "enter valid number") Long id){
        log.info("get restaurant with id={} from database", id);
        return restaurantService.getRestaurantById(id);
    }

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Restaurant getRestaurantByName(@RequestParam  String name){
        log.info("get restaurant with name={} from database", name);
        return restaurantService.getRestaurantByName(name);
    }

    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteRestaurant(@PathVariable @Min(value = 1, message = "Element Not Found") Long id){
        log.info("delete restaurant with id={} from database", id);
        restaurantService.deleteRestaurant(id);
    }
}
