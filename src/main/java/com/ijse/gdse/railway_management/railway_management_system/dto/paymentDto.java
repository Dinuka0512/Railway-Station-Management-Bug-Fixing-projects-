package com.ijse.gdse.railway_management.railway_management_system.dto;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class paymentDto {
    private String p_id ;
    private String amount;
    private String booking_id ;
    private Date date;
    private String method;

}
