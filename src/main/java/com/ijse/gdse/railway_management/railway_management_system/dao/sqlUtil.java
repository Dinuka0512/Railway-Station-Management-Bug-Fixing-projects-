package com.ijse.gdse.railway_management.railway_management_system.dao;

import com.ijse.gdse.railway_management.railway_management_system.db.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class sqlUtil {

    public static <T> execute(String sql, Object... params) {
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().preparedStatement(sql, params);
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject((i + 1), params);
        }
        if (sql.startsWith("SELECT") || sql.startsWith("select")) {
            return (T) preparedStatement.executeQuery();
        }
        return (T) (boolean) preparedStatement.executeUpdate();

    }
}

