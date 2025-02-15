package com.ijse.gdse.railway_management.railway_management_system.dao;

import com.ijse.gdse.railway_management.railway_management_system.dao.custom.impl.*;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getInstance(){
      return daoFactory==null? daoFactory=new DAOFactory():daoFactory;
}

    public enum DAOtype{
        user,booking,admin,login,payment,schedule,train,
    }

    public static crudDAO getDAO(DAOFactory.DAOtype daOtype) {
        switch (daOtype) {
            case user:
                return new userDAOImpl();
            case booking:
                return new bookingDAOImpl();
            case admin:
                return new adminDAOImpl();
            case login:
                return new loginDAOImpl();
            case payment:
                return new paymentDAOImpl();
            case schedule:
                return new scheduleDAOImpl();
            case train: {
                return new trainDAOImpl();
            }
            default: {
                return null;
            }
        }
    }
}
