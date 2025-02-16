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
        String sql = "SELECT u_id FROM user ORDER BY u_id DESC LIMIT 1";
        ResultSet res = crudUtil.execute(sql);
        if (res.next()) {
            String lastId = res.getString("u_id");
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

    @Override
    public boolean save(User dto) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO user VALUES (?, ?, ?, ?, ?)";
        return crudUtil.execute(query, dto.getU_id(), dto.getName(), dto.getContact_no(), dto.getGmail(), dto.getPassword());
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
