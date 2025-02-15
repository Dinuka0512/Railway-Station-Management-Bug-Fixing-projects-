package com.ijse.gdse.railway_management.railway_management_system.bo.custom;

import com.ijse.gdse.railway_management.railway_management_system.bo.superBO;
import com.ijse.gdse.railway_management.railway_management_system.dto.userDto;

import java.util.ArrayList;

public interface userBO extends superBO {

    boolean delete(String text) throws Exception;

    boolean save(userDto userDto) throws Exception;

    boolean update(userDto userDto) throws Exception;

    ArrayList<userDto> getAll() throws Exception;

}
