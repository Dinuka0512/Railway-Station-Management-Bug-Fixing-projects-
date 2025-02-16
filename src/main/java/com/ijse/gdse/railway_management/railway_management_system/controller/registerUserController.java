package com.ijse.gdse.railway_management.railway_management_system.controller;

import com.ijse.gdse.railway_management.railway_management_system.bo.BOFactory;
import com.ijse.gdse.railway_management.railway_management_system.bo.custom.UserBo;
import com.ijse.gdse.railway_management.railway_management_system.entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class registerUserController implements Initializable {
    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtName;

    @FXML
    private Label lblUId;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    //=====
    private UserBo userBo = (UserBo) BOFactory.getInstance().getBO(BOFactory.BOType.USER);
    //=====

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void registerUsersONAction(ActionEvent event) {

    }
}
