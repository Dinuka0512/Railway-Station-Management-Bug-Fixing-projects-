package com.ijse.gdse.railway_management.railway_management_system.dao.cusom.impl;

import com.ijse.gdse.railway_management.railway_management_system.dao.cusom.PassengerDAO;
import com.ijse.gdse.railway_management.railway_management_system.entity.Passenger;

import java.sql.SQLException;
import java.util.ArrayList;

public class PassengerDAOimpl implements PassengerDAO {
    @Override
    public ArrayList<Passenger> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Passenger dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Passenger dto) throws SQLException, ClassNotFoundException {
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
    public String generateNewId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public Passenger search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
