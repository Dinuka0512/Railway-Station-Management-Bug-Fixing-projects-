package com.ijse.gdse.railway_management.railway_management_system.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Ticket {
    private String ticket_Id;
    private String issue_Date;
    private String booking_Id;
    private double price;
}
