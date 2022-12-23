package com.fawry.foodorderingapi.model;

import com.fawry.foodorderingapi.entity.AppUser;
import com.fawry.foodorderingapi.entity.Restaurant;
import com.fawry.foodorderingapi.entity.SubOrder;
import lombok.*;

import javax.persistence.*;

import java.util.List;


@Data
public class GroupDTO {
    private Long id;

    private String title;

    private boolean anyOneCanJoinWithoutRequest;

    private boolean groupIsFinished;

    private Restaurant restaurant;

    private List<AppUser> Users;

    private List<AppUser> UsersRequestToJoin;

    private List<SubOrder> order;
}
