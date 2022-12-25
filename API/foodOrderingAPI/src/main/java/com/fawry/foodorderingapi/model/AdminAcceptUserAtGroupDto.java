package com.fawry.foodorderingapi.model;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AdminAcceptUserAtGroupDto {
    private Long groupId;
    private Long userId;
}
