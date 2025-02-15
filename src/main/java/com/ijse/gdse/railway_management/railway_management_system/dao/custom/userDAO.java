package com.ijse.gdse.railway_management.railway_management_system.dao.custom;

import com.ijse.gdse.railway_management.railway_management_system.dao.crudDAO;
import com.ijse.gdse.railway_management.railway_management_system.dto.userDto;
import com.ijse.gdse.railway_management.railway_management_system.util.crudUtil;

public interface userDAO extends crudDAO {

     String handleRegisterUser(userDto userDto) throws Exception;
}
