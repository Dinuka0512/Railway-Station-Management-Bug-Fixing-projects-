package com.ijse.gdse.railway_management.railway_management_system.entity;

import java.sql.Date;

public class payment {
    private String p_id ;
    private String amount;
    private String booking_id ;
    private Date date;
    private String method;

    public payment(String p_id, String amount, String booking_id, Date date, String method) {
        this.p_id = p_id;
        this.amount = amount;
        this.booking_id = booking_id;
        this.date = date;
        this.method = method;
    }
    public payment() {
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(String booking_id) {
        this.booking_id = booking_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
