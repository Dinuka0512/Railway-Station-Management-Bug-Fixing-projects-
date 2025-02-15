package com.ijse.gdse.railway_management.railway_management_system.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Payment {
    private String p_Id;
    private double amount;
    private String booking_Id;
    private String date;
    private String pt_Id;
}
