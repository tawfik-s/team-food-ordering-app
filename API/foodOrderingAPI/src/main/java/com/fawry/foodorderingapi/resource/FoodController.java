package com.fawry.foodorderingapi.resource;

import com.fawry.foodorderingapi.entity.Food;
import com.fawry.foodorderingapi.mapper.FoodMapper;
import com.fawry.foodorderingapi.model.FoodDto;
import com.fawry.foodorderingapi.service.FoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("foods")
@Slf4j
public class FoodController {
    @Autowired
    private FoodService foodService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Food addFood(@RequestBody FoodDto foodDto){
        log.info("added food={} to database ", foodDto);
        Food food = FoodMapper.INSTANCE.mapToFood(foodDto);
        return foodService.addFood(food);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Food> getAll(){
        log.info("get all foods from database");
        return foodService.getAll();
    }

    @GetMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public Food getById(@PathVariable @Min(value = 1, message = "enter valid number") Long id){
        log.info("get food by id={} from database :", id);
        return foodService.getFoodById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Food updateFood(@RequestBody FoodDto foodDto){
        log.info("update food={} to database ", foodDto);
        Food food = FoodMapper.INSTANCE.mapToFood(foodDto);
        return foodService.updateFood(food);
    }

    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFood(@PathVariable @Min(value = 1, message = "Element Not Found") Long id){
        log.info("delete food with id={} from database", id);
        foodService.deleteFood(id);
    }
}
