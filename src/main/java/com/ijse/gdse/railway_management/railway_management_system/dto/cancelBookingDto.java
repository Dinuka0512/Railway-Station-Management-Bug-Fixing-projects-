package com.ijse.gdse.railway_management.railway_management_system.dto;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class cancelBookingDto {

    private String CancellationId;
    private String bookingId;
    private String passengerId;
    private String reason;
    private Date Date;


}
