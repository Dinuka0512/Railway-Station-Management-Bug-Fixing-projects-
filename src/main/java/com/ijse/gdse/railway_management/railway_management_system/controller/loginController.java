package com.ijse.gdse.railway_management.railway_management_system.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class loginController {
    @FXML
    private PasswordField password;

    @FXML
    private Button btnLogin;

    @FXML
    private TextField usernameTxt;

    @FXML
    private AnchorPane content;

    @FXML
    void btnLogin_OnAction(ActionEvent event) {
        //HERE WE LOG IN TO THE DASHBOARD

    }

    @FXML
    void navigateToRegister(ActionEvent event) {

    }

}
