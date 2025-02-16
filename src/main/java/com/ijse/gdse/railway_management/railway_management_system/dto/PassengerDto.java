package com.ijse.gdse.railway_management.railway_management_system.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class PassengerDto {
    private String passenger_Id;
    private String name;
    private String email;
    private String contact;
}
