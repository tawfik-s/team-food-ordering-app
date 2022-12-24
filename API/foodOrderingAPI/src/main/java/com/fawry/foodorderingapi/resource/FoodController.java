package com.fawry.foodorderingapi.resource;

import com.fawry.foodorderingapi.entity.Food;
import com.fawry.foodorderingapi.mapper.FoodMapper;
import com.fawry.foodorderingapi.model.FoodDto;
import com.fawry.foodorderingapi.service.FoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

@RestController
@RequestMapping("foods")
@Slf4j
public class FoodController {
    @Autowired
    private FoodService foodService;

    @PostMapping
    public ResponseEntity<?> addFood(@RequestBody FoodDto foodDto){
        log.info("added food={} to database ", foodDto);
        Food food = FoodMapper.INSTANCE.mapToFood(foodDto);
        return ResponseEntity.ok().body(foodService.addFood(food));
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        log.info("get all foods from database");
    return ResponseEntity.ok().body(foodService.getAll());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> getById(@PathVariable @Min(value = 1, message = "enter valid number") Long id){
        log.info("get food by id={} from database :", id);
        return ResponseEntity.ok().body(foodService.getFoodById(id));
    }

    @PutMapping
    public ResponseEntity<?> updateFood(@RequestBody FoodDto foodDto){
        log.info("update food={} to database ", foodDto);
        Food food = FoodMapper.INSTANCE.mapToFood(foodDto);
        return ResponseEntity.ok().body(foodService.updateFood(food));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deleteFood(@PathVariable @Min(value = 1, message = "Element Not Found") Long id){
        log.info("delete food with id={} from database", id);
        foodService.deleteFood(id);
        return ResponseEntity.noContent().build();
    }
}
