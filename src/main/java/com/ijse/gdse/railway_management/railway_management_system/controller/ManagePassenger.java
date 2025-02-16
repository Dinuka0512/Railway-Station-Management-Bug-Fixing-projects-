package com.ijse.gdse.railway_management.railway_management_system.controller;

import com.ijse.gdse.railway_management.railway_management_system.bo.BOFactory;
import com.ijse.gdse.railway_management.railway_management_system.bo.custom.PassengerBO;
import com.ijse.gdse.railway_management.railway_management_system.dto.PassengerDto;
import com.ijse.gdse.railway_management.railway_management_system.dto.tm.PassengerTM;
import com.ijse.gdse.railway_management.railway_management_system.util.validation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ManagePassenger implements Initializable {
    @FXML
    private Label lblId;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtName;

    @FXML
    private TableColumn<PassengerTM, String> columnId;

    @FXML
    private TableView<PassengerTM> passengerTable;

    @FXML
    private TableColumn<PassengerTM, String> columnContact;

    @FXML
    private TextField txtEmail;

    @FXML
    private TableColumn<PassengerTM, String> columnEmail;

    @FXML
    private TableColumn<PassengerTM, String> columnName;

    //==========
    private PassengerBO passengerBO = (PassengerBO) BOFactory.getInstance().getBO(BOFactory.BOType.PASSENGER);
    //==========

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnId.setCellValueFactory(new PropertyValueFactory<>("passenger_Id"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        loadTable();
        generateId();
    }

    private void generateId() {
        try{
            lblId.setText(passengerBO.genarateId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void loadTable() {
        try{
            ArrayList<PassengerDto> dtos = passengerBO.getAllDetails();
            ObservableList<PassengerTM> passengerTMS = FXCollections.observableArrayList();
            for(PassengerDto passenger : dtos){
                PassengerTM passengerTM = new PassengerTM(
                        passenger.getPassenger_Id(),
                        passenger.getName(),
                        passenger.getEmail(),
                        passenger.getContact()
                );
                passengerTMS.add(passengerTM);
            }

            passengerTable.setItems(passengerTMS);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void save(ActionEvent event) {
        if(validation.isValidName(txtName.getText())){
            if(validation.isValidEmail(txtEmail.getText())){
                if(validation.isValidMobileNumber(txtContact.getText())){
                    //ALL OK
                    saveNow();
                }else {
                    new Alert(Alert.AlertType.WARNING, "Invalid contact").show();
                }
            }else {
                new Alert(Alert.AlertType.WARNING, "Invalid email enterd").show();
            }
        }else {
            new Alert(Alert.AlertType.WARNING, "Invalid name").show();
        }
    }

    private void saveNow() {
        try{
            PassengerDto passengerDto =  new PassengerDto(
                    lblId.getText(),
                    txtName.getText(),
                    txtEmail.getText(),
                    txtContact.getText()
            );

            if(passengerBO.save(passengerDto)){
                generateId();
                loadTable();
                clearText();
                new Alert(Alert.AlertType.CONFIRMATION, "Saved").show();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void clearText() {
        txtEmail.setText("");
        txtContact.setText("");
        txtName.setText("");

        txtEmail.setPromptText("email");
        txtName.setPromptText("name");
        txtContact.setPromptText("contact");
    }

    @FXML
    void delete(ActionEvent event) {
        try {
            PassengerTM selectedPassenger = passengerTable.getSelectionModel().getSelectedItem();
            if (selectedPassenger != null) {
                boolean isDeleted = passengerBO.deletePassenger(selectedPassenger.getPassenger_Id());
                if (isDeleted) {
                    // Remove the deleted passenger from the table
                    passengerTable.getItems().remove(selectedPassenger);
                    new Alert(Alert.AlertType.INFORMATION, "Passenger deleted successfully!").show();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Failed to delete the passenger.").show();
                }
            } else {
                new Alert(Alert.AlertType.WARNING, "Please select a passenger to delete.").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "An error occurred while deleting the passenger.").show();
        }
    }

    @FXML
    void update(ActionEvent event) {

    }

    @FXML
    void loadTableData(MouseEvent event) {
        PassengerTM passenger = passengerTable.getSelectionModel().getSelectedItem();
        if (passenger != null) {
            System.out.println(passenger);
            lblId.setText(passenger.getPassenger_Id());
            txtName.setText(passenger.getName());
            txtContact.setText(passenger.getContact());
            txtEmail.setText(passenger.getEmail());
        }
    }
}
