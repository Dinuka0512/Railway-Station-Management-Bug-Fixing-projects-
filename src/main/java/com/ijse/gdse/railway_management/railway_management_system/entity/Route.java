package com.ijse.gdse.railway_management.railway_management_system.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Route {
    private String r_Id;
    private String start_Station;
    private String end_Station;
    private double distance;
    private String train_id;
}
