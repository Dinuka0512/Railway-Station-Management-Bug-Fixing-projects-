package com.ijse.gdse.railway_management.railway_management_system.dao.cusom;

import com.ijse.gdse.railway_management.railway_management_system.dao.SuperDAO;
import com.ijse.gdse.railway_management.railway_management_system.dto.UserDto;
import com.ijse.gdse.railway_management.railway_management_system.entity.User;

import java.sql.SQLException;

public interface UserDAO extends SuperDAO {
    User getUserDetails(String email) throws SQLException, ClassNotFoundException;
}
