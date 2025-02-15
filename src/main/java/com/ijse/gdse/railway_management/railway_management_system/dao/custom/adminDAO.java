package com.ijse.gdse.railway_management.railway_management_system.dao.custom;

import com.ijse.gdse.railway_management.railway_management_system.dao.crudDAO;
import com.ijse.gdse.railway_management.railway_management_system.dto.registerAdminDto;
import com.ijse.gdse.railway_management.railway_management_system.util.crudUtil;

import java.sql.SQLException;

public interface adminDAO extends crudDAO {

     boolean saveUser(registerAdminDto registerAdminDto) throws SQLException, ClassNotFoundException;

}
