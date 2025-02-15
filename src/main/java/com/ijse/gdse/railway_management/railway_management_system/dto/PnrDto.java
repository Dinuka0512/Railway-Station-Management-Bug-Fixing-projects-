package com.ijse.gdse.railway_management.railway_management_system.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class PnrDto {
    private String pnr_number;
    private String status;
    private String booking_Id;
}
