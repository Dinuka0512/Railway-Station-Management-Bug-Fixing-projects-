package com.ijse.gdse.railway_management.railway_management_system.dto;

import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UserDto {
    private String user_Id;
    private String name;
    private String email;
    private String contact;
    private String password;
}
