package com.ijse.gdse.railway_management.railway_management_system.bo.custom.impl;

import com.ijse.gdse.railway_management.railway_management_system.dto.userDto;
import com.ijse.gdse.railway_management.railway_management_system.bo.custom.userBO;
import com.ijse.gdse.railway_management.railway_management_system.dao.*;
import java.util.ArrayList;

public class userBOImpl implements userBO {

   userDAO userDAO = (userDAO) DAOFactory.getInstance().getDao(DAOFActory.DaoType.user);

    @Override
    public ArrayList<userDto> getAll() throws Exception {
        ArrayList<user> users=userDAO.getAll();
        ArrayList<userDto> userDtos=new ArrayList<>();
        for (user user:users) {
            userDtos.add(new userDto(user.getu_id(), user.getname(), user.getcontact(),
                    user.getgmail()));
        }
        return userDtos;
    }

    @Override
    public String getNextUserId() throws Exception {
        return userDAO.generateNewId();
    }

    @Override
    public boolean updateUser(userDto userDto) throws Exception {
        return userDAO.update(new userEntity(
                userDto.getu_iD(),
                userDto.getName(),
                userDto.getcontact(),
                userDto.getgmail()));
    }

    @Override
    public boolean saveuser(userDto userDto) throws Exception {
        return customerDao.save(new userEntity(
                userDto.getu_iD(),
                userDto.getName(),
                userDto.getcontact(),
                userDto.getgmail()));
    }

    @Override
    public boolean deleteuser(String text) throws Exception {
        return userDAO.delete(text);

    }

}
