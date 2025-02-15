package com.ijse.gdse.railway_management.railway_management_system.bo;

import com.ijse.gdse.railway_management.railway_management_system.bo.custom.impl.userBOImpl;


public class BOFactory {
    private static BOFactory serviceFactory;

    private BOFactory(){}

    public static BOFactory getInstance(){
        return serviceFactory == null ? new BOFactory() : serviceFactory;
    }

    public superBO getService(serviceType type){
        switch (type) {
            case user:
                return new userBOImpl();

            default:
                return null;
        }
    }

    public enum serviceType{
        user
    }



}
