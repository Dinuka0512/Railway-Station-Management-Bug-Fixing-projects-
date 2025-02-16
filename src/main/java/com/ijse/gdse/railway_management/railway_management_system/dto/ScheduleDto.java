package com.ijse.gdse.railway_management.railway_management_system.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ScheduleDto {
    private String schedule_Id;
    private String date;
    private String train_Id;
}
