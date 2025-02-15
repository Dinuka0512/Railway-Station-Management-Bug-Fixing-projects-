package com.ijse.gdse.railway_management.railway_management_system.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class TicketDto {
    private String t_id;
    private String Issue_date;
    private String booking_Id;
    private String price;
}
