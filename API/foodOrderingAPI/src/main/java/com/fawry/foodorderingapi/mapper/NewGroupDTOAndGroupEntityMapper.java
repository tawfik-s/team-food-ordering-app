package com.fawry.foodorderingapi.mapper;


import com.fawry.foodorderingapi.entity.AppGroup;
import com.fawry.foodorderingapi.model.NewGroupDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface NewGroupDTOAndGroupEntityMapper {


    @Mapping(target = "title",source = "newGroupDTO.title")
    @Mapping(target="anyOneCanJoinWithoutRequest",source = "newGroupDTO.anyOneCanJoinWithoutRequest")
    public AppGroup NewGroupDTOToAppGroup(NewGroupDTO newGroupDTO);
}
