package com.ijse.gdse.railway_management.railway_management_system.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Schedule {
    private String s_id;
    private String arrival_time;
    private String start_point;
    private String departure_time;
    private String destinatiom;
    private String travel_date;
    private String train_id;
}
