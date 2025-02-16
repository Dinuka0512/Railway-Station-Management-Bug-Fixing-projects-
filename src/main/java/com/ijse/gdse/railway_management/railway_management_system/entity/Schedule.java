package com.ijse.gdse.railway_management.railway_management_system.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Schedule {
    private String schedule_Id;
    private String date;
    private String train_Id;
}
