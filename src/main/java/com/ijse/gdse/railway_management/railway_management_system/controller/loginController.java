package com.ijse.gdse.railway_management.railway_management_system.controller;

import com.ijse.gdse.railway_management.railway_management_system.bo.BOFactory;
import com.ijse.gdse.railway_management.railway_management_system.bo.custom.UserBo;
import com.ijse.gdse.railway_management.railway_management_system.dto.UserDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class loginController {
    @FXML
    private PasswordField password;

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtEmail;

    @FXML
    private AnchorPane content;

    //=====
    private UserBo userBo = (UserBo) BOFactory.getInstance().getBO(BOFactory.BOType.USER);
    //=====
    @FXML
    void btnLogin_OnAction(ActionEvent event) {
        //CHECKING THE USER NAME AND PASSWORD
        try{
            UserDto userDetails = userBo.getUserDetails(txtEmail.getText());
            if(userDetails != null){
                if(password.getText().equals(userDetails.getPassword())){
                    //ALL OK
                    gotoDashboard();
                }else {
                    new Alert(Alert.AlertType.ERROR, "Invalid Password").show();
                }
            }else{
                new Alert(Alert.AlertType.WARNING,"User not Found").show();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void gotoDashboard() {
        try{
            content.getChildren().clear();
            AnchorPane load = FXMLLoader.load(getClass().getResource("/view/mainView.fxml"));
            content.getChildren().add(load);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void navigateToRegister(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/registerUser.fxml"));
            AnchorPane pane = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(pane));
            stage.setTitle("Register User");
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
