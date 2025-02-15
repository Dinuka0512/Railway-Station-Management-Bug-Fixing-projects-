package com.ijse.gdse.railway_management.railway_management_system.dao;

import com.ijse.gdse.railway_management.railway_management_system.dto.trainManagementDto;
import com.ijse.gdse.railway_management.railway_management_system.util.crudUtil;

import java.sql.SQLException;

public interface crudDAO <T>{

     boolean save(T trainDto) throws SQLException, ClassNotFoundException;

     boolean update(T dto) throws SQLException, ClassNotFoundException;

    boolean delete(T trainId) throws SQLException, ClassNotFoundException;
}
