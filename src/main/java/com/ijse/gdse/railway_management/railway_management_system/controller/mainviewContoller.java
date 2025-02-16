package com.ijse.gdse.railway_management.railway_management_system.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class mainviewContoller {
    @FXML
    private Button btnLogout;

    @FXML
    private AnchorPane body;

    @FXML
    private AnchorPane content;

    @FXML
    void navigateToPromotion(ActionEvent event) {

    }

    @FXML
    void navigateToBookingManagement(ActionEvent event) {

    }

    @FXML
    void navigateToScheduleManagement(ActionEvent event) {

    }

    @FXML
    void navigateToTrainManagement(ActionEvent event) {

    }

    @FXML
    void navigateToUserManagement(ActionEvent event) {

    }

    @FXML
    void navigateToBooking(ActionEvent event) {
        //Book seats
        try{
            content.getChildren().clear();
            AnchorPane load = FXMLLoader.load(getClass().getResource("/view/bookingView.fxml"));
            content.getChildren().add(load);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void logoutOnAction(ActionEvent event) {
        try{
            body.getChildren().clear();
            AnchorPane load = FXMLLoader.load(getClass().getResource("/view/loginView.fxml"));
            body.getChildren().add(load);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void navigateToRegisterUser(ActionEvent event) {
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
