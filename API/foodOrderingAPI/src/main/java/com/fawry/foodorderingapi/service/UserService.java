package com.fawry.foodorderingapi.service;

import com.fawry.foodorderingapi.model.UsersDto;

public interface UserService {

    //TODO add check if user is group owner
    public UsersDto createUser(UsersDto usersDto);
}
