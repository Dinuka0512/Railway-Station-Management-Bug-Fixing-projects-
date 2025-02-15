package com.ijse.gdse.railway_management.railway_management_system.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Station {
    private String st_id;
    private String st_name;
    private String location;
    private String route_id;
}
