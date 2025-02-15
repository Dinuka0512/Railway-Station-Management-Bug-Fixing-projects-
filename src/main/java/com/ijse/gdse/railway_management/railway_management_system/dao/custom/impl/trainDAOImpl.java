package com.ijse.gdse.railway_management.railway_management_system.dao.custom.impl;


import com.ijse.gdse.railway_management.railway_management_system.dao.custom.adminDAO;
import com.ijse.gdse.railway_management.railway_management_system.dao.custom.trainDAO;
import com.ijse.gdse.railway_management.railway_management_system.dto.trainManagementDto;
import com.ijse.gdse.railway_management.railway_management_system.util.crudUtil;

import java.sql.SQLException;

public class trainDAOImpl implements trainDAO {


    public boolean saveTrain(trainManagementDto trainDto) throws SQLException, ClassNotFoundException {
        return true;
    }

    public boolean updateTrain(trainManagementDto dto) throws SQLException, ClassNotFoundException {
        return true;
    }


    public boolean deleteTrain(String trainId) throws SQLException, ClassNotFoundException {
        return crudUtil.execute("delete from train where tr_id=?", trainId);
    }

}



