package com.ijse.gdse.railway_management.railway_management_system.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class RouteDto {
    private String route_Id;
    private String start_Location;
    private String end_Location;
    private double distance;
    private String train_Id;
}
