package com.ijse.gdse.railway_management.railway_management_system.db;

import lombok.Getter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@Getter
public class DBConnection {
    private static com.ijse.gdse.railway_management.railway_management_system.db.DBConnection dbConnection;
        private Connection connection;
        private DBConnection() throws SQLException {

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/railway",
                    "root",
                    "0512"
            );
        }
        public static com.ijse.gdse.railway_management.railway_management_system.db.DBConnection getInstance() throws SQLException {
            if (dbConnection==null){
                dbConnection=new com.ijse.gdse.railway_management.railway_management_system.db.DBConnection();
            }
            return dbConnection;
        }
        public Connection getConnection(){
            return connection;
        }
    }






