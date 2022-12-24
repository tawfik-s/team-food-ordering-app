package com.fawry.foodorderingapi.mapper;

import com.fawry.foodorderingapi.entity.AppGroup;
import com.fawry.foodorderingapi.entity.AppUser;
import com.fawry.foodorderingapi.model.NewGroupDTO;
import com.fawry.foodorderingapi.model.UsersDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper
public interface NewUserDTOAndAppUserEntityMapper {

    @Mapping(target = "name",source = "usersDto.name")
    @Mapping(target="phone",source = "usersDto.phone")
    @Mapping(target="password",source = "usersDto.password")
    public AppUser NewGroupDTOToAppGroup(UsersDto usersDto);
}
