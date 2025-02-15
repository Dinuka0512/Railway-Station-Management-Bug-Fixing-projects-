package com.ijse.gdse.railway_management.railway_management_system.dao.custom;

import com.ijse.gdse.railway_management.railway_management_system.dao.crudDAO;
import com.ijse.gdse.railway_management.railway_management_system.util.crudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface loginDAO extends crudDAO {

    String getUserName(String username) throws SQLException, ClassNotFoundException;

    String getPassword(String password, String username) throws SQLException;

  }