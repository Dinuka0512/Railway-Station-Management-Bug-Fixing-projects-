package com.ijse.gdse.railway_management.railway_management_system.dto;

import lombok.*;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor


public class scheduleDto {
    private String s_id;
    private Time arrival;
    private String start_point;
    private Time departure;
    private String destination ;
    private Date travel_date;
    private String train_id;

}
