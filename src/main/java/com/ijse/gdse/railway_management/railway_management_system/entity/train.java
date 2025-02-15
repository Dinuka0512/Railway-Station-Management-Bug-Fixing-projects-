package com.ijse.gdse.railway_management.railway_management_system.entity;

public class train {
    private String  tr_id  ;
    private String   tr_name ;
    private String  type ;
    private String booking_id;

    public train(String tr_id, String tr_name, String type, String booking_id) {
        this.tr_id = tr_id;
        this.tr_name = tr_name;
        this.type = type;
        this.booking_id = booking_id;
    }

    public train() {
    }

    public String getTr_id() {
        return tr_id;
    }

    public void setTr_id(String tr_id) {
        this.tr_id = tr_id;
    }

    public String getTr_name() {
        return tr_name;
    }

    public void setTr_name(String tr_name) {
        this.tr_name = tr_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(String booking_id) {
        this.booking_id = booking_id;
    }
}
