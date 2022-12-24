package com.fawry.foodorderingapi.repository;

import com.fawry.foodorderingapi.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepo extends JpaRepository<Food,Long> {
<<<<<<< HEAD
=======
    Food findFoodById(Long id);
>>>>>>> origin/tawfeek1
}
