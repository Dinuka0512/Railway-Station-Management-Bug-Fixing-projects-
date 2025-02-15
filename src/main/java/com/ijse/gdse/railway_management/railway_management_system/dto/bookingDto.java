package com.ijse.gdse.railway_management.railway_management_system.dto;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class bookingDto {
    private String b_id;
    private Date b_date;
    private String  user_id ;
    private int  total_fare ;
    private String status;
    private String  tr_id ;
    private String from ;
    private String to;
    private  int no_of_passengers;
}
