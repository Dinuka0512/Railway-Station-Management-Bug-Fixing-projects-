package com.ijse.gdse.railway_management.railway_management_system.bo.custom;

import com.ijse.gdse.railway_management.railway_management_system.bo.SuperBo;
import com.ijse.gdse.railway_management.railway_management_system.dto.UserDto;

import java.sql.SQLException;

public interface UserBo extends SuperBo {
    UserDto getUserDetails(String email) throws SQLException, ClassNotFoundException;
    String genarateUserId() throws SQLException, ClassNotFoundException;
    boolean saveUser(UserDto dto) throws SQLException, ClassNotFoundException;
}
