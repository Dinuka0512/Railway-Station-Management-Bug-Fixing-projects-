package com.ijse.gdse.railway_management.railway_management_system.entity;

import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class User {
    private String user_Id;
    private String name;
    private String email;
    private String contact;
    private String password;
}
