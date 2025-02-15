package com.ijse.gdse.railway_management.railway_management_system.dto.tm;


import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class promotionTm {
  private String pr_id;
  private String pr_name ;
  private Date start_date ;
  private Date end_date ;
  private String booking_id;
  private String description ;
}
