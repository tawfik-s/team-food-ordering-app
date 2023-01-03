package com.fawry.foodorderingapi.model;


import lombok.*;

import javax.validation.constraints.Min;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AdminAcceptUserAtGroupDto {
    @Min(value = 1, message = "Enter valid Id")
    private Long groupId;
    @Min(value = 1, message = "Enter valid Id")
    private Long userId;
}
