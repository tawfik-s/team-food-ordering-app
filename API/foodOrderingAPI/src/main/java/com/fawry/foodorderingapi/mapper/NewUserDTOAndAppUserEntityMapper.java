package com.fawry.foodorderingapi.mapper;

import com.fawry.foodorderingapi.entity.AppUser;
import com.fawry.foodorderingapi.model.UsersDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper
public interface NewUserDTOAndAppUserEntityMapper {

    @Mapping(target = "name",source = "usersDto.name")
    @Mapping(target="phone",source = "usersDto.phone")
    @Mapping(target="password",source = "usersDto.password")
    @Mapping(target="email",source = "usersDto.email")
    public AppUser userDtoModelToAppUserEntity(UsersDto usersDto);
}
