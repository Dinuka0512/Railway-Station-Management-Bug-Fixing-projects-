package com.ijse.gdse.railway_management.railway_management_system.entity;

import java.sql.Date;
import java.sql.Time;

public class schedule {
    private String s_id;
    private Time arrival;
    private String start_point;
    private Time departure;
    private String destination ;
    private Date travel_date;
    private String train_id;

    public schedule(String s_id, Time arrival, String start_point, Time departure, String destination, Date travel_date, String train_id) {
        this.s_id = s_id;
        this.arrival = arrival;
        this.start_point = start_point;
        this.departure = departure;
        this.destination = destination;
        this.travel_date = travel_date;
        this.train_id = train_id;
    }
    public schedule() {
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public Time getArrival() {
        return arrival;
    }

    public void setArrival(Time arrival) {
        this.arrival = arrival;
    }

    public String getStart_point() {
        return start_point;
    }

    public void setStart_point(String start_point) {
        this.start_point = start_point;
    }

    public Time getDeparture() {
        return departure;
    }

    public void setDeparture(Time departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getTravel_date() {
        return travel_date;
    }

    public void setTravel_date(Date travel_date) {
        this.travel_date = travel_date;
    }

    public String getTrain_id() {
        return train_id;
    }

    public void setTrain_id(String train_id) {
        this.train_id = train_id;
    }
}
