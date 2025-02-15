package com.ijse.gdse.railway_management.railway_management_system.bo.custom.impl;

import com.ijse.gdse.railway_management.railway_management_system.bo.custom.bookingBO;
import com.ijse.gdse.railway_management.railway_management_system.bo.custom.trainBO;
import com.ijse.gdse.railway_management.railway_management_system.dto.bookingDto;

import java.sql.SQLException;
import java.util.ArrayList;

import static DAOFactory.DAOtype.booking;

public class bookingBOImpl  implements bookingBO {
    bookingDAO bookingDAO= (bookingDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOtype.booking);
    @Override
    public ArrayList<bookingDto> getAllItem() throws SQLException, ClassNotFoundException {
        ArrayList<booking> bookings=bookingDAO.getAll();
        ArrayList<bookingDto> bookingDtos=new ArrayList<>();
        for (booking booking:bookings) {
            bookingDtos.add(new bookingDto(booking.getB_id(),booking.getB_date(),booking.getUser_id(),booking.getTotal_fare(),booking.getStatus(),booking.getTr_id(),booking.getFrom(),booking.getTo(),booking. getNo_of_passengers()));
        }
        return bookingDtos;
    }

    @Override
    public boolean savebooking(bookingDto dto) throws SQLException, ClassNotFoundException {
        return bookingDAO.save(new booking(dto.getB_id(),dto.getB_date(),dto.getUser_id(),dto.getTotal_fare(),dto.getStatus(),dto.getTr_id(),dto.getFrom(),dto.getTo(),dto.getNo_of_passengers()));
    }

    @Override
    public boolean updatebooking(bookingDto dto) throws SQLException, ClassNotFoundException {
        return bookingDAO.update(new booking(dto.getB_id(),dto.getB_date(),dto.getUser_id(),dto.getTotal_fare(),dto.getStatus(),dto.getTr_id(),dto.getFrom(),dto.getTo(),dto.getNo_of_passengers()));
    }


    @Override
    public void deletebooking(String B_id) throws SQLException, ClassNotFoundException {
        bookingDAO.delete(B_id);
    }


}
