package com.ijse.gdse.railway_management.railway_management_system.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Pnr {
    private String pnr_number;
    private String status;
    private String booking_Id;
}
