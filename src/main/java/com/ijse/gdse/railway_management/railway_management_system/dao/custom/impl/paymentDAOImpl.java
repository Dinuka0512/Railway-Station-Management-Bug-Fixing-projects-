package com.ijse.gdse.railway_management.railway_management_system.dao.custom.impl;

import com.ijse.gdse.railway_management.railway_management_system.dao.custom.adminDAO;
import com.ijse.gdse.railway_management.railway_management_system.dao.custom.paymentDAO;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class paymentDAOImpl implements paymentDAO {
    private String p_id;
    private Double amount;
    private String booking_id    ;
    private String date;
    private String method;

    public paymentDAOImpl getAll() {
        return null;

}
