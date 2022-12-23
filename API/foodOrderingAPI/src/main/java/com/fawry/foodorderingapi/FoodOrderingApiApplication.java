package com.fawry.foodorderingapi;

import com.fawry.foodorderingapi.entity.AppGroup;
import com.fawry.foodorderingapi.entity.AppUser;
import com.fawry.foodorderingapi.entity.Restaurant;
import com.fawry.foodorderingapi.model.NewGroupDTO;
import com.fawry.foodorderingapi.repository.AppUserRepo;
import com.fawry.foodorderingapi.repository.RestaurantRepo;
import com.fawry.foodorderingapi.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FoodOrderingApiApplication {

    @Autowired
    private AppUserRepo appUserRepo;
    @Autowired
    private RestaurantRepo restaurantRepo;

    public static void main(String[] args) {
        SpringApplication.run(FoodOrderingApiApplication.class, args);
    }


    @Bean
    CommandLineRunner run(GroupService groupService){
        return args -> {
//          AppUser appUser1=  appUserRepo.save(new AppUser(null,"usef","0100232342","1234",null,null));
//          AppUser appUser2=   appUserRepo.save(new AppUser(null,"tawfeek","0100232342","1234",null,null));
//          System.out.println(appUser1);
//          System.out.println(appUser2);
//          Restaurant restaurant= restaurantRepo.save(new Restaurant(null,"tarek","110077",null));
//            System.out.println(restaurant);
//          AppGroup appGroup1=groupService.addGroup(appUser1.getId(),new NewGroupDTO("group1","true",restaurant.getId()));
//            System.out.println(appGroup1);
//          groupService.userJoinGroup(appGroup1.getId(),appUser2.getId());

        };
    }

}
