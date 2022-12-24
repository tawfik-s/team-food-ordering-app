package com.fawry.foodorderingapi.model;

import com.fawry.foodorderingapi.entity.AppUser;
import com.fawry.foodorderingapi.entity.Restaurant;
import com.fawry.foodorderingapi.entity.SubOrder;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;


@Data
public class GroupDTO {
    private Long id;
    @Size(min = 2, max = 400, message = "The Title of Gruop is not valid")
    private String title;

    private boolean anyOneCanJoinWithoutRequest;

    private boolean groupIsFinished;

    @NotNull(message = "You Shoude Choose Restaurant")
    private Restaurant restaurant;

    private List<AppUser> Users;

    private List<AppUser> UsersRequestToJoin;

    private List<SubOrder> order;
}
