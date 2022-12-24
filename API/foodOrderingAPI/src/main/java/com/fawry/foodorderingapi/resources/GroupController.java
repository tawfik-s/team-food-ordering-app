package com.fawry.foodorderingapi.resources;

import com.fawry.foodorderingapi.entity.AppGroup;
import com.fawry.foodorderingapi.entity.AppUser;
import com.fawry.foodorderingapi.model.GroupDTO;
import com.fawry.foodorderingapi.model.UsersDto;
import com.fawry.foodorderingapi.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/group")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping
    public List<GroupDTO> getAllGroups() {
        return groupService.getAvailableGroups();
    }
}
