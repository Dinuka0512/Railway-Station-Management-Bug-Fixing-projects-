package com.ijse.gdse.railway_management.railway_management_system.dto.tm;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class PassengerTM {
    private String passenger_Id;
    private String name;
    private String email;
    private String contact;
}
