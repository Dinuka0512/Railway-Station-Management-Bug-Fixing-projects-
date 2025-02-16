package com.ijse.gdse.railway_management.railway_management_system.dao;

import com.ijse.gdse.railway_management.railway_management_system.dao.cusom.impl.PassengerDAOimpl;
import com.ijse.gdse.railway_management.railway_management_system.dao.cusom.impl.UserDAOimpl;

public class DAOFactory {
    public static DAOFactory daoFactory;
    private DAOFactory(){}

    public static DAOFactory getInstance(){
        if(daoFactory == null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public enum DAOType{
        USER,PASSENGER
    }

    public SuperDAO getDAO(DAOType type){
        switch (type){
            case USER -> {
                return new UserDAOimpl();
            }
            case PASSENGER -> {
                return new PassengerDAOimpl();
            }
            default -> {
                return null;
            }
        }
    }
}
