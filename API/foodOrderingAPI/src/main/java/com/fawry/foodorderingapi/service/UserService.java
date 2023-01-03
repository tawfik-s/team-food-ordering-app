package com.fawry.foodorderingapi.service;

import com.fawry.foodorderingapi.entity.AppUser;
import com.fawry.foodorderingapi.model.LoginCredentials;
import com.fawry.foodorderingapi.model.UsersDto;

import java.util.Map;

public interface UserService {

    public UsersDto createUser(UsersDto usersDto);

    Map<String, Object> registerUser(UsersDto usersDto);

    Map<String, Object> loginUser(LoginCredentials credentials);

    //    public Map<String, Object> registerUser(UsersDto usersDto);
//    public Map<String, Object> loginUser(LoginCredentials credentials);
    public AppUser getCurrentUser();
}
