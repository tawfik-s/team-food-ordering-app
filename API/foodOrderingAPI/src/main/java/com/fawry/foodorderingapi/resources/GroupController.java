package com.fawry.foodorderingapi.resources;

import com.fawry.foodorderingapi.entity.AppGroup;
import com.fawry.foodorderingapi.entity.AppUser;
import com.fawry.foodorderingapi.entity.Order;
import com.fawry.foodorderingapi.exception.RecordNotFoundException;
import com.fawry.foodorderingapi.model.*;
import com.fawry.foodorderingapi.repository.AppUserRepo;
import com.fawry.foodorderingapi.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @Autowired
    private AppUserRepo appUserRepo;

    @GetMapping
    public List<GroupDTO> getAllGroups() {
        return groupService.getAvailableGroups();
    }

    @PostMapping
    public AppGroup addGroup(@RequestBody NewGroupDTO newGroupDTO) {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser = appUserRepo.findByEmail(email)
                .orElseThrow(() -> new RecordNotFoundException("you are not authorized to add group"));
        return groupService.addGroup(appUser.getId(), newGroupDTO);
    }

    @PostMapping("/finish")
    public Long finishGroup(@RequestBody GroupId groupId) {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser = appUserRepo.findByEmail(email)
                .orElseThrow(() -> new RecordNotFoundException("you are not authorized to add group"));
        int present = appUser.getOwnedGroups()
                .stream()
                .filter(
                        (group) -> group.getId() == groupId.getGroupId())
                .collect(Collectors.toList()).size();
        if(present==0){
            throw new RecordNotFoundException("you are not authorized to access this group");
        }
        groupService.finishGroup(groupId.getGroupId());
        return groupId.getGroupId();
    }

    @PostMapping("/accept")
    public void adminAcceptUserAtGroup(@RequestBody AdminAcceptUserAtGroupDto adminAcceptUserAtGroupDto){
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser = appUserRepo.findByEmail(email)
                .orElseThrow(() -> new RecordNotFoundException("you are not authorized to add group"));
        int present = (int) appUser.getOwnedGroups()
                .stream()
                .filter(
                        (group) -> group.getId() == adminAcceptUserAtGroupDto.getGroupId()).count();
        if(present==0){
            throw new RecordNotFoundException("you are not authorized to access this group");
        }
        groupService.adminAcceptUserAtGroup(adminAcceptUserAtGroupDto.getGroupId(), adminAcceptUserAtGroupDto.getUserId());
    }

    @PostMapping("/join")
    @ResponseStatus(HttpStatus.OK)
    public void askToJoinGroup(@RequestBody AskToJoinGroupDTO askToJoinGroupDTO){
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser = appUserRepo.findByEmail(email)
                .orElseThrow(() -> new RecordNotFoundException("you are not authorized to join group"));
        groupService.userJoinGroup(askToJoinGroupDTO.getGroupId(),appUser.getId());
    }


    @GetMapping(path = "{id}")
    public GroupDTO getOneGroup(@PathVariable @Min(value = 1, message = "enter valid number") Long id){

        return groupService.getGroup(id);
    }

    @GetMapping(path = "/isAdmin/{id}")
    public boolean is_Admin(@PathVariable @Min(value = 1, message = "enter valid number") Long id ){
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(email);
        AppUser appUser = appUserRepo.findByEmail(email)
                .orElseThrow(() -> new RecordNotFoundException("you are not authorized to add group"));
        return groupService.isAdmin(id,appUser.getId());
    }

    @GetMapping(path = "/isGroupUser/{groupId}")
    public boolean isGroupUser(@PathVariable Long groupId){

        return groupService.isGroupUser(groupId);
    }

}
