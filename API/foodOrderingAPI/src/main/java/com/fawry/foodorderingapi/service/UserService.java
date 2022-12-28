package com.fawry.foodorderingapi.service;

import com.fawry.foodorderingapi.entity.AppUser;
import com.fawry.foodorderingapi.model.UsersDto;

public interface UserService {

    //TODO add check if user is group owner
    public UsersDto createUser(UsersDto usersDto);


    //TODO add GET curret logged in user
    public AppUser getCurrentUser();
}
