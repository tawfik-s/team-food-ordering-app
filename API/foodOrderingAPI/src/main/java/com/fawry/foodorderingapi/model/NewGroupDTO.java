package com.fawry.foodorderingapi.model;

import com.fawry.foodorderingapi.entity.Restaurant;
import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NewGroupDTO {

    private String title;

    private String anyOneCanJoinWithoutRequest;  //flag to make group public

    private Long restaurantId;

}
