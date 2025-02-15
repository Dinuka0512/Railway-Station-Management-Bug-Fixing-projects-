package com.ijse.gdse.railway_management.railway_management_system.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString


public class registerAdminDto {
    private String username;
    private String password;
    private int contact_no;
    private String gmail;

    /*public registerDto(String id, String password, String gmail, int contactNo) {

    }*/

    /*public static Object getusername() {
        return null;
    }

    public static Object getpassword() {
        return null;
    }

    public static Object getcontact_no() {
        return null;
    }

    public static Object getgmail() {
        return null;
    }*/
}
