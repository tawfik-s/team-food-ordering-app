package com.fawry.foodorderingapi.resources;

import com.fawry.foodorderingapi.entity.Food;
import com.fawry.foodorderingapi.model.FoodDto;
import com.fawry.foodorderingapi.service.FoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("foods")
@Slf4j
@Validated
public class FoodController {
    @Autowired
    private FoodService foodService;

    @PostMapping("toRestaurants/{restaurantId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Food addFood(@Valid @PathVariable Long restaurantId, @RequestBody FoodDto foodDto ){
        log.info("added food={} to restaurant with id={} ", foodDto, restaurantId);
        return foodService.addFood(restaurantId, foodDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Food> getAll(){
        log.info("get all foods from database");
        return foodService.getAll();
    }

    @GetMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public Food getById(@Valid @PathVariable  Long id){
        log.info("get food by id={} from database :", id);
        return foodService.getFoodById(id);
    }

    @PutMapping(path = "{foodId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateFood(@Valid @PathVariable Long foodId, @RequestBody FoodDto foodDto){
        log.info("update food={} with id={} ", foodDto, foodId);
        foodService.updateFood(foodId,foodDto);
    }

    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFood(@Valid @PathVariable  Long id){
        log.info("delete food with id={} from database", id);
        foodService.deleteFood(id);
    }
}
