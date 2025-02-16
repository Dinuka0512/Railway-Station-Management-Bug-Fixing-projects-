package com.ijse.gdse.railway_management.railway_management_system.bo.custom.impl;

import com.ijse.gdse.railway_management.railway_management_system.bo.custom.UserBo;
import com.ijse.gdse.railway_management.railway_management_system.dao.DAOFactory;
import com.ijse.gdse.railway_management.railway_management_system.dao.cusom.UserDAO;
import com.ijse.gdse.railway_management.railway_management_system.dto.UserDto;
import com.ijse.gdse.railway_management.railway_management_system.entity.User;

import java.sql.SQLException;

public class UserBoimpl implements UserBo {
    private UserDAO userDAO = (UserDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.USER);
    @Override
    public UserDto getUserDetails(String email) throws SQLException, ClassNotFoundException {
        User user = userDAO.getUserDetails(email);
        return (user != null)? new UserDto(user.getUser_Id(), user.getName(), user.getContact(), user.getEmail(), user.getPassword()) : null;
    }

    @Override
    public String genarateUserId() throws SQLException, ClassNotFoundException {
        return userDAO.generateNewId();
    }

    @Override
    public boolean saveUser(UserDto dto) throws SQLException, ClassNotFoundException {
        return userDAO.save(new User(dto.getUser_Id(), dto.getName(), dto.getContact(), dto.getEmail(), dto.getPassword()));
    }

}
