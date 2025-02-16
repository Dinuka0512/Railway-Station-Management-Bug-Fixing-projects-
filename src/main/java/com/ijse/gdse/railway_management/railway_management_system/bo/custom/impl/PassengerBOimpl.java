package com.ijse.gdse.railway_management.railway_management_system.bo.custom.impl;

import com.ijse.gdse.railway_management.railway_management_system.bo.custom.PassengerBO;
import com.ijse.gdse.railway_management.railway_management_system.dao.DAOFactory;
import com.ijse.gdse.railway_management.railway_management_system.dao.cusom.PassengerDAO;
import com.ijse.gdse.railway_management.railway_management_system.dto.PassengerDto;
import com.ijse.gdse.railway_management.railway_management_system.entity.Passenger;

import java.sql.SQLException;
import java.util.ArrayList;

public class PassengerBOimpl implements PassengerBO {
    private PassengerDAO passengerDAO = (PassengerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.PASSENGER);
    @Override
    public ArrayList<PassengerDto> getAllDetails() throws SQLException, ClassNotFoundException {
        ArrayList<Passenger> passengers = passengerDAO.getAll();
        ArrayList<PassengerDto> dtos = new ArrayList<>();
        for(Passenger passenger : passengers){
            PassengerDto passengerDto = new PassengerDto(
                    passenger.getPassenger_Id(),
                    passenger.getName(),
                    passenger.getEmail(),
                    passenger.getContact()
            );

            dtos.add(passengerDto);
        }

        return dtos;
    }

    @Override
    public String genarateId() throws SQLException, ClassNotFoundException {
        return passengerDAO.generateNewId();
    }

    @Override
    public boolean deletePassenger(String id) throws SQLException, ClassNotFoundException {
        return passengerDAO.delete(id);
    }

    @Override
    public boolean save(PassengerDto passengerDto) throws SQLException, ClassNotFoundException {
        return passengerDAO.save(new Passenger(passengerDto.getPassenger_Id(), passengerDto.getName(), passengerDto.getEmail(), passengerDto.getContact()));
    }


}
