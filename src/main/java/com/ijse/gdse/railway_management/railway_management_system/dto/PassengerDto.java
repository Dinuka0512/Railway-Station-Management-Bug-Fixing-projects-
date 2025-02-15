package com.ijse.gdse.railway_management.railway_management_system.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class PassengerDto {
    private String pa_id;
    private String pa_name;
    private String booking_Id;
    private String seat_No;
}
