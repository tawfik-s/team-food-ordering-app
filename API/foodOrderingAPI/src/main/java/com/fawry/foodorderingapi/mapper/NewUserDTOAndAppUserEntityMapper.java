package com.fawry.foodorderingapi.mapper;

import com.fawry.foodorderingapi.entity.AppUser;
import com.fawry.foodorderingapi.model.UsersDto;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface NewUserDTOAndAppUserEntityMapper {

    public AppUser toEntity(UsersDto usersDto);
}
