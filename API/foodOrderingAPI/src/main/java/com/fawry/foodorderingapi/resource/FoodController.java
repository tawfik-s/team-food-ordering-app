package com.fawry.foodorderingapi.resource;

import com.fawry.foodorderingapi.entity.Food;
import com.fawry.foodorderingapi.mapper.FoodMapper;
import com.fawry.foodorderingapi.model.FoodDto;
import com.fawry.foodorderingapi.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("foods")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @PostMapping
    public ResponseEntity<?> addFood(@RequestBody FoodDto foodDto){
        Food food = FoodMapper.INSTANCE.mapToFood(foodDto);
        return ResponseEntity.ok().body(foodService.addFood(food));
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
    return ResponseEntity.ok().body(foodService.getAll());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok().body(foodService.getFoodById(id));
    }

    @PutMapping
    public ResponseEntity<?> updateFood(@RequestBody FoodDto foodDto){
        Food food = FoodMapper.INSTANCE.mapToFood(foodDto);
        return ResponseEntity.ok().body(foodService.updateFood(food));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deleteFood(@PathVariable Long id){
        foodService.deleteFood(id);
        return ResponseEntity.ok().build();
    }
}
