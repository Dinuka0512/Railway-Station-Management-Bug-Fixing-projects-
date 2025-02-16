package com.ijse.gdse.railway_management.railway_management_system.dao.cusom.impl;

import com.ijse.gdse.railway_management.railway_management_system.dao.cusom.UserDAO;
import com.ijse.gdse.railway_management.railway_management_system.entity.User;
import com.ijse.gdse.railway_management.railway_management_system.util.crudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAOimpl implements UserDAO {
    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT user_Id FROM user ORDER BY user_Id DESC LIMIT 1";
        ResultSet res = crudUtil.execute(sql);
        if (res.next()) {
            String lastId = res.getString("user_Id");
            String subString = lastId.substring(1);

            int i = Integer.parseInt(subString);
            i = i + 1;
            String newId = String.format("U%03d", i);

            return newId;
        }
        return "U001";

    }

    @Override
    public User getUserDetails(String email) throws SQLException, ClassNotFoundException {
        String sql = "select * from user where email = ?";
        ResultSet res =  crudUtil.execute(sql, email);
        if(res.next()){
            return new User(
                    res.getString("user_Id"),
                    res.getString("name"),
                    res.getString("email"),
                    res.getString("contact"),
                    res.getString("password")
            );
        }
        return null;
    }

    @Override
    public boolean save(User dto) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO user VALUES (?, ?, ?, ?, ?)";
        return crudUtil.execute(query, dto.getUser_Id(), dto.getName(), dto.getEmail(), dto.getContact(), dto.getPassword());
    }

    @Override
    public ArrayList<User> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(User dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public User search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
