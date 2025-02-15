package com.ijse.gdse.railway_management.railway_management_system.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class StationDto {
    private String st_id;
    private String st_name;
    private String location;
    private String route_id;
}
