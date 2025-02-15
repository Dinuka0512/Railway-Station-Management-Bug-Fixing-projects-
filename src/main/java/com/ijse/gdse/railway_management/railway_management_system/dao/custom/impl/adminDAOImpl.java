package com.ijse.gdse.railway_management.railway_management_system.dao.custom.impl;


import com.ijse.gdse.railway_management.railway_management_system.dao.custom.adminDAO;
import com.ijse.gdse.railway_management.railway_management_system.dto.registerAdminDto;
import com.ijse.gdse.railway_management.railway_management_system.util.crudUtil;

import java.sql.SQLException;

public class adminDAOImpl implements adminDAO {
    public boolean saveUser(registerAdminDto registerAdminDto) throws SQLException, ClassNotFoundException {
        return crudUtil.execute(
                "insert into admin values (?,?,?,?)",
                registerAdminDto.getUsername(),
                registerAdminDto.getPassword(),
                registerAdminDto.getContact_no(),
                registerAdminDto.getGmail()

        );
    }

}
