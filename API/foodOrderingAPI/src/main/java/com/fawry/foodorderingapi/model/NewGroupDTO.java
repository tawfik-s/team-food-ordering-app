package com.fawry.foodorderingapi.model;

import com.fawry.foodorderingapi.entity.Restaurant;
import lombok.*;

import javax.validation.constraints.Size;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NewGroupDTO {
    @Size(min = 2, max = 400, message = "The Title of Group is not valid")
    private String title;
    @Size(min = 2, max = 400, message = "Any One Can Join Without Request is not valid")
    private String anyOneCanJoinWithoutRequest;  //flag to make group public

    private Long restaurantId;



}
