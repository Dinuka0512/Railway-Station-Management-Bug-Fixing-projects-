package com.ijse.gdse.railway_management.railway_management_system.entity;

public class user {
    private  String u_id;
    private  String name;
    private int contact_no;
    private String gmail;


    public user(String u_id,String name,int contact_no,String gmail){
        this.u_id= u_id;
        this.name=name;
        this.contact_no=contact_no;
        this.gmail=gmail;
    }
    public user(){
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
