package com.ijse.gdse.railway_management.railway_management_system.bo.custom;

import com.ijse.gdse.railway_management.railway_management_system.bo.SuperBo;
import com.ijse.gdse.railway_management.railway_management_system.dto.PassengerDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PassengerBO extends SuperBo {
    ArrayList<PassengerDto> getAllDetails() throws SQLException, ClassNotFoundException;
    String genarateId()throws SQLException, ClassNotFoundException;
    boolean deletePassenger(String id)throws SQLException, ClassNotFoundException;
    boolean save(PassengerDto passengerDto) throws SQLException, ClassNotFoundException;
}
