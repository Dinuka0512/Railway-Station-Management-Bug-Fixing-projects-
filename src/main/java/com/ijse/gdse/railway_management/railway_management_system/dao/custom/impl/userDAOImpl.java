package com.ijse.gdse.railway_management.railway_management_system.dao.custom.impl;

import com.ijse.gdse.railway_management.railway_management_system.dao.custom.adminDAO;
import com.ijse.gdse.railway_management.railway_management_system.dao.custom.userDAO;
import com.ijse.gdse.railway_management.railway_management_system.dto.userDto;
import com.ijse.gdse.railway_management.railway_management_system.util.crudUtil;

public class userDAOImpl implements userDAO {


    public String handleRegisterUser(userDto userDto) throws Exception{
        String sql = "insert into user values(?,?,?,?)";
        Boolean resp = crudUtil.execute(sql,userDto.getU_id(),userDto.getName(),userDto.getContact_no(),userDto.getGmail());
        return resp == Boolean.TRUE ? "success" : "fail";
    }
}
