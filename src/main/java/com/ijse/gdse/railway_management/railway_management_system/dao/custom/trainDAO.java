package com.ijse.gdse.railway_management.railway_management_system.dao.custom;

import com.ijse.gdse.railway_management.railway_management_system.dao.crudDAO;
import com.ijse.gdse.railway_management.railway_management_system.dto.trainManagementDto;
import com.ijse.gdse.railway_management.railway_management_system.util.crudUtil;

import java.sql.SQLException;

public interface trainDAO extends crudDAO {

    boolean saveTrain(trainManagementDto trainDto) throws SQLException, ClassNotFoundException;

    boolean updateTrain( trainManagementDto dto) throws SQLException, ClassNotFoundException;

    boolean deleteTrain(String trainId) throws SQLException, ClassNotFoundException;
}
