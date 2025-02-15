package com.ijse.gdse.railway_management.railway_management_system.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Booking {
    private String b_Id;
    private String b_date;
    private String tr_id;
    private String from_station;
    private String to_station;
    private String user_Id;
    private double total_fare;
    private String status;
}
