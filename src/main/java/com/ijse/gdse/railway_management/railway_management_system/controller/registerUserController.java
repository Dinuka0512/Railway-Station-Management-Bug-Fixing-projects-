package com.ijse.gdse.railway_management.railway_management_system.controller;

import com.ijse.gdse.railway_management.railway_management_system.bo.BOFactory;
import com.ijse.gdse.railway_management.railway_management_system.bo.custom.UserBo;
import com.ijse.gdse.railway_management.railway_management_system.dto.UserDto;
import com.ijse.gdse.railway_management.railway_management_system.entity.User;
import com.ijse.gdse.railway_management.railway_management_system.util.validation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

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
        genarateId();
    }

    private void genarateId() {
        try{
            lblUId.setText(userBo.genarateUserId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void registerUsersONAction(ActionEvent event) {
        //SAVE USER
        if(validation.isValidName(txtName.getText())){
            if(validation.isValidEmail(txtEmail.getText())){
                if(validation.isValidMobileNumber(txtContact.getText())){
                    if(validation.isValidPassword(txtPassword.getText())){
                        //CHECKING OK
                        saveUser();
                    }else{
                        new Alert(Alert.AlertType.WARNING,"Use the Strong password").show();
                    }
                }else{
                    new Alert(Alert.AlertType.WARNING,"Invalid contact").show();
                }
            }else{
                new Alert(Alert.AlertType.WARNING,"Invalid email").show();
            }
        }else{
            new Alert(Alert.AlertType.WARNING, "Invalid name").show();
        }
    }

    private void saveUser() {
        try{
            if(userBo.saveUser(new UserDto(lblUId.getText(), txtName.getText(), txtContact.getText(), txtEmail.getText(), txtPassword.getText()))){
                clearTexts();
                new Alert(Alert.AlertType.CONFIRMATION,"New User saved").show();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void clearTexts() {
        txtName.setText("");
        txtEmail.setText("");
        txtContact.setText("");
        txtPassword.setText("");

        txtContact.setPromptText("contact");
        txtName.setPromptText("name");
        txtEmail.setPromptText("email");
        txtPassword.setPromptText("password");

        genarateId();
    }
}
