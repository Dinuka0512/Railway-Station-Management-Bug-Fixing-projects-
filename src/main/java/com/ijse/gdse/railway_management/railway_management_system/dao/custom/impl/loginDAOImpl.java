package com.ijse.gdse.railway_management.railway_management_system.dao.custom.impl;

import com.ijse.gdse.railway_management.railway_management_system.dao.custom.adminDAO;
import com.ijse.gdse.railway_management.railway_management_system.dao.custom.loginDAO;
import com.ijse.gdse.railway_management.railway_management_system.util.crudUtil;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginDAOImpl implements loginDAO {
   public String getUserName(String username)throws SQLException,ClassNotFoundException{
      String sql = "select username from admin where username= ?";
        ResultSet res =crudUtil.execute(sql,username);
        if(res.next()){
            return res.getString("username");

        }
        return null;
    }

        public String getPassword(String password,String username)throws SQLException,ClassNotFoundException{
            String sql = "select password from admin where password = ? and username = ?";
            ResultSet res =crudUtil.execute(sql,password,username);
            if(res.next()){
                return res.getString("password");

            }
            return null;

    }
}
