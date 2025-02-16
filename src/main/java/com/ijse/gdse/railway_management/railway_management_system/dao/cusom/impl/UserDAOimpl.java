package com.ijse.gdse.railway_management.railway_management_system.dao.cusom.impl;

import com.ijse.gdse.railway_management.railway_management_system.dao.cusom.UserDAO;
import com.ijse.gdse.railway_management.railway_management_system.entity.User;
import com.ijse.gdse.railway_management.railway_management_system.util.crudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOimpl implements UserDAO {
    @Override
    public User getUserDetails(String email) throws SQLException, ClassNotFoundException {
        String sql = "select * from user where gmail = ?";
        ResultSet res =  crudUtil.execute(sql, email);
        if(res.next()){
            return new User(
                    res.getString("u_id"),
                    res.getString("name"),
                    res.getString("contact_no"),
                    res.getString("gmail"),
                    res.getString("password")
            );
        }
        return null;
    }
}
