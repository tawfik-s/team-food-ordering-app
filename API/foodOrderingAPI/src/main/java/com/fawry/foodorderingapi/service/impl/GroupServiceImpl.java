package com.fawry.foodorderingapi.service.impl;

import com.fawry.foodorderingapi.entity.AppGroup;
import com.fawry.foodorderingapi.entity.AppUser;
import com.fawry.foodorderingapi.entity.Restaurant;
import com.fawry.foodorderingapi.exception.GroupNotFoundException;
import com.fawry.foodorderingapi.exception.RestaurantNotFoundException;
import com.fawry.foodorderingapi.exception.UserNotFoundException;
import com.fawry.foodorderingapi.mapper.NewGroupDTOAndGroupEntityMapper;
import com.fawry.foodorderingapi.model.GroupDTO;
import com.fawry.foodorderingapi.model.NewGroupDTO;
import com.fawry.foodorderingapi.repository.AppGroupRepo;
import com.fawry.foodorderingapi.repository.AppUserRepo;
import com.fawry.foodorderingapi.repository.RestaurantRepo;
import com.fawry.foodorderingapi.service.GroupService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private AppUserRepo userRepo;

    @Autowired
    private AppGroupRepo groupRepo;

    @Autowired
    private RestaurantRepo restaurantRepo;
    private NewGroupDTOAndGroupEntityMapper newGroupDTOAndGroupEntityMapper = Mappers.getMapper(NewGroupDTOAndGroupEntityMapper.class);

    @Override
    @Transactional
    public AppGroup addGroup(Long userId, NewGroupDTO newGroup) {
        AppUser appUser = userRepo.findById(userId).orElseThrow(UserNotFoundException::new);
        AppGroup appGroup = newGroupDTOAndGroupEntityMapper.NewGroupDTOToAppGroup(newGroup);
        Restaurant restaurant = restaurantRepo.findById(newGroup.getRestaurantId()).orElseThrow(RestaurantNotFoundException::new);
        appGroup.setGroupIsFinished("false");
        appGroup.setRestaurant(restaurant);
        appGroup = groupRepo.save(appGroup);
        appUser.getOwnedGroups().add(appGroup);
        userRepo.save(appUser);
        return appGroup;
    }

    @Override
    @Transactional
    public void finishGroup(Long groupId) {
        AppGroup appGroup = groupRepo.findById(groupId).orElseThrow(GroupNotFoundException::new);
        appGroup.setGroupIsFinished("true");
        groupRepo.save(appGroup);
    }

    @Override
    @Transactional
    public void userJoinGroup(Long groupId, Long userId) {
        AppGroup appGroup = groupRepo.findById(groupId).orElseThrow(GroupNotFoundException::new);
        AppUser appUser = userRepo.findById(userId).orElseThrow(UserNotFoundException::new);
        List<AppGroup> appGroups = appUser.getOwnedGroups()
                .stream()
                .filter(appGroup1 -> appGroup1.getId() == groupId)
                .collect(Collectors.toList());
        System.out.println(appGroups.isEmpty());
        //TODO chick is admin group
        if (appGroups.isEmpty()) {
            if (appGroup.getAnyOneCanJoinWithoutRequest().equals("true")) {
                appGroup.getUsers().add(appUser);
            } else {
                appGroup.getUsersRequestToJoin().add(appUser);
            }
            groupRepo.save(appGroup);
        }
    }

    @Override
    @Transactional
    public void adminAcceptUserAtGroup(Long groupId, Long newUserId) {
        AppGroup appGroup = groupRepo.findById(groupId).orElseThrow(GroupNotFoundException::new);
        AppUser appUser = userRepo.findById(newUserId).orElseThrow(UserNotFoundException::new);
        List<AppUser> list = appGroup.getUsersRequestToJoin()
                .stream()
                .filter(appUser1 -> appUser1.getId() == newUserId)
                .collect(Collectors.toList());
        //TODO Chick user in Users Request To Join
        if (!list.isEmpty()) {
            appGroup.getUsersRequestToJoin().removeIf((user) -> user.getId() == appUser.getId());
            appGroup.getUsers().add(appUser);
            groupRepo.save(appGroup);
        }
    }

    @Override
    @Transactional
    public List<GroupDTO> getAvailableGroups() {
        List<AppGroup> appGroup1 = groupRepo.findAll().stream()
                .filter((appGroup) -> appGroup.getGroupIsFinished().equals("false"))
                .collect(Collectors.toList());
        List<GroupDTO> groupDTO = new ArrayList<>();
        for (AppGroup group : appGroup1) {
            GroupDTO groupDTO1 = new GroupDTO(group.getId(),group.getTitle(), group.getAnyOneCanJoinWithoutRequest(), group.getGroupIsFinished(), group.getRestaurant(), group.getUsers(),group.getUsersRequestToJoin(), group.getOrder());
            groupDTO.add(groupDTO1);
        }
        return groupDTO;
    }
}
