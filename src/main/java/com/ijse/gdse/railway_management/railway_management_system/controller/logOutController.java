package com.ijse.gdse.railway_management.railway_management_system.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class logOutController {

    @FXML
    private Button btnLogout;

    @FXML
    private AnchorPane content;

    @FXML
    void logoutOnAction(ActionEvent event) {
}
    Stage stage;

    public void logout(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("do you really want to logout!");

        if(alert.showAndWait().get() == ButtonType.OK){
            stage = (Stage) content.getScene().getWindow();
            System.out.println("logged out successfully !");
            stage.close();

            }

    }
}
