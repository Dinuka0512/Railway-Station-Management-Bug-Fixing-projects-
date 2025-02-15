package com.ijse.gdse.railway_management.railway_management_system.dto.tm;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class bookingTm {
    private String b_id;
    private String b_date;
    private String  user_id ;
    private Double total_fare ;
    private String status;
    private String  tr_id ;
    private String from ;
    private String to;
    private  int no_of_passengers;

}
