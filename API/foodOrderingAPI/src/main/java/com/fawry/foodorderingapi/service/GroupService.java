package com.fawry.foodorderingapi.service;

import com.fawry.foodorderingapi.entity.AppGroup;
import com.fawry.foodorderingapi.entity.Order;
import com.fawry.foodorderingapi.model.GroupDTO;
import com.fawry.foodorderingapi.model.NewGroupDTO;

import java.util.List;

public interface GroupService {

    public AppGroup addGroup(Long userId, NewGroupDTO newGroup);

    public void finishGroup(Long groupId);

    public void userJoinGroup(Long groupId,Long userId);

    public void adminAcceptUserAtGroup(Long groupId,Long newUserId);

    public List<GroupDTO> getAvailableGroups();

    public GroupDTO getGroup(Long id);

    public boolean isAdmin(Long groupId, Long userId);

    public boolean isGroupUser(Long groupId);




}
