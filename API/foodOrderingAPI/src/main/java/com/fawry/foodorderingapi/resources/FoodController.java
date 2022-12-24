package com.fawry.foodorderingapi.resources;

import com.fawry.foodorderingapi.entity.Food;
import com.fawry.foodorderingapi.mapper.FoodMapper;
import com.fawry.foodorderingapi.models.FoodCreationDto;
import com.fawry.foodorderingapi.service.FoodService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {


    @Autowired
    private FoodService foodService;


    private FoodMapper foodMapper = Mappers.getMapper(FoodMapper.class);


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public FoodCreationDto addFood (@RequestBody FoodCreationDto foodDto){

        Food food = foodMapper.mapToEntity(foodDto);
        FoodCreationDto foodCreationDto = foodMapper.mapToDto(foodService.addFood(food));
        return foodCreationDto;

    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Food> getAllFood(){
        return foodService.getAllFood();
}

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Food getFoodById(@PathVariable Long id){
        return foodService.getFoodById(id);
    }


}
