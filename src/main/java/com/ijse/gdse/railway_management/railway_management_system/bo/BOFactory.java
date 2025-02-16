package com.ijse.gdse.railway_management.railway_management_system.bo;

import com.ijse.gdse.railway_management.railway_management_system.bo.custom.impl.UserBoimpl;

public class BOFactory {
    public static BOFactory boFactory;
    private BOFactory(){
    }

    public static BOFactory getInstance(){
        if(boFactory == null){
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public enum BOType{
        USER
    }

    public SuperBo getBO(BOType type){
        switch (type){
            case USER -> {
                return new UserBoimpl();
            }
            default -> {
                return null;
            }
        }
    }

}
