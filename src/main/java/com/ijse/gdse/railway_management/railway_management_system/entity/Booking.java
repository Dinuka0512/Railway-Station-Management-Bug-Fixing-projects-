package com.ijse.gdse.railway_management.railway_management_system.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Booking {
    private String booking_Id;
    private String date;
    private String schedule_Id;
    private String from_station;
    private String to_station;
    private String pay_Id;
    private String class_Id;
    private double amount;
    private int ticket_count;
}
