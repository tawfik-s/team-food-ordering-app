package com.fawry.foodorderingapi.service.impl;

import com.fawry.foodorderingapi.entity.AppUser;
import com.fawry.foodorderingapi.exception.RecordNotFoundException;
import com.fawry.foodorderingapi.mapper.NewUserDTOAndAppUserEntityMapper;
import com.fawry.foodorderingapi.model.UsersDto;
import com.fawry.foodorderingapi.repository.AppUserRepo;
import com.fawry.foodorderingapi.service.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private AppUserRepo userRepo;
    private NewUserDTOAndAppUserEntityMapper mapper = Mappers.getMapper(NewUserDTOAndAppUserEntityMapper.class);
    @Override
    public UsersDto createUser(UsersDto usersDto) {
        AppUser user = mapper.userDtoModelToAppUserEntity(usersDto);
        userRepo.save(user);
        return usersDto;
    }

    public AppUser getCurrentUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = auth.getName();
        AppUser currentUser = userRepo.findByEmail(currentUserName).orElseThrow(
                ()-> new RecordNotFoundException("User NOt Found")
        );

        return currentUser;
    }
}
