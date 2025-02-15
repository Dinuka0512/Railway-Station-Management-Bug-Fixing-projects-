package com.ijse.gdse.railway_management.railway_management_system.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Passenger {
    private String pa_id;
    private String pa_name;
    private String booking_Id;
    private String seat_No;
}
