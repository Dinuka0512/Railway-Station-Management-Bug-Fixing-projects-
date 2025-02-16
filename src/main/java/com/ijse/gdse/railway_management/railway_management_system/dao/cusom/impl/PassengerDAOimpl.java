package com.ijse.gdse.railway_management.railway_management_system.dao.cusom.impl;

import com.ijse.gdse.railway_management.railway_management_system.dao.cusom.PassengerDAO;
import com.ijse.gdse.railway_management.railway_management_system.entity.Passenger;
import com.ijse.gdse.railway_management.railway_management_system.util.crudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PassengerDAOimpl implements PassengerDAO {
    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT passenger_Id FROM passenger ORDER BY passenger_Id DESC LIMIT 1";
        ResultSet res = crudUtil.execute(sql);
        if (res.next()) {
            String lastId = res.getString("passenger_Id");
            String subString = lastId.substring(1);

            int i = Integer.parseInt(subString);
            i = i + 1;
            String newId = String.format("P%03d", i);

            return newId;
        }
        return "P001";
    }

    @Override
    public ArrayList<Passenger> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM passenger";
        ResultSet res = crudUtil.execute(sql);
        ArrayList<Passenger> passengerList = new ArrayList<>();

        while (res.next()) {
            Passenger passenger = new Passenger(
                    res.getString("passenger_Id"),
                    res.getString("name"),
                    res.getString("email"),
                    res.getString("contact")
            );
            passengerList.add(passenger);
        }

        return passengerList;
    }

    @Override
    public boolean save(Passenger dto) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO passenger (passenger_Id, name, email, contact) VALUES (?, ?, ?, ?)";
        return crudUtil.execute(sql, dto.getPassenger_Id(), dto.getName(), dto.getEmail(), dto.getContact());
    }

    @Override
    public boolean update(Passenger dto) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE passenger SET name = ?, email = ?, contact = ? WHERE passenger_Id = ?";
        return crudUtil.execute(sql, dto.getName(), dto.getEmail(), dto.getContact(), dto.getPassenger_Id());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM passenger WHERE passenger_Id = ?";
        return crudUtil.execute(sql, id);
    }

    @Override
    public Passenger search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
