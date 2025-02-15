package com.ijse.gdse.railway_management.railway_management_system.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class PromotionDto {
    private String pr_id;
    private String pr_name;
    private String start_date;
    private String end_date;
    private String booking_id;
    private String description;
}
