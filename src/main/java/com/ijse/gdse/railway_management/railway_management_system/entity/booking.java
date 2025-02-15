package com.ijse.gdse.railway_management.railway_management_system.entity;

import java.sql.Date;

public class booking {

    private String b_id;
    private Date b_date;
    private String  user_id ;
    private int  total_fare ;
    private String status;
    private String  tr_id ;
    private String from ;
    private String to;
    private  int no_of_passengers;

    public booking(String b_id, Date b_date, String user_id, int total_fare, String status, String tr_id, String from, String to, int no_of_passengers) {
        this.b_id = b_id;
        this.b_date = b_date;
        this.user_id = user_id;
        this.total_fare = total_fare;
        this.status = status;
        this.tr_id = tr_id;
        this.from = from;
        this.to = to;
        this.no_of_passengers = no_of_passengers;
    }

    public booking() {
    }

    public String getB_id() {
        return b_id;
    }

    public void setB_id(String b_id) {
        this.b_id = b_id;
    }

    public Date getB_date() {
        return b_date;
    }

    public void setB_date(Date b_date) {
        this.b_date = b_date;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getTotal_fare() {
        return total_fare;
    }

    public void setTotal_fare(int total_fare) {
        this.total_fare = total_fare;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTr_id() {
        return tr_id;
    }

    public void setTr_id(String tr_id) {
        this.tr_id = tr_id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getNo_of_passengers() {
        return no_of_passengers;
    }

    public void setNo_of_passengers(int no_of_passengers) {
        this.no_of_passengers = no_of_passengers;
    }
}

