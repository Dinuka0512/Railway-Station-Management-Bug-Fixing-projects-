package com.ijse.gdse.railway_management.railway_management_system.entity;

public class admin {
    private String username;
    private String password;
    private int contact_no;
    private String gmail;

public admin(String username, String password, int contact_no,String gmail){
    this.username=username;
    this.password = password;
    this.contact_no = contact_no;
    this.gmail = gmail;
}
    public admin() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getContact_no() {
        return contact_no;
    }

    public void setContact_no(int contact_no) {
        this.contact_no = contact_no;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
}
