package com.ijse.gdse.railway_management.railway_management_system.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class PaymentDto {
    private String p_Id;
    private double amount;
    private String booking_Id;
    private String date;
    private String pt_Id;
}
