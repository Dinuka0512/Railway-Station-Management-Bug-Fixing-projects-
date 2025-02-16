package com.ijse.gdse.railway_management.railway_management_system.controller;

import com.ijse.gdse.railway_management.railway_management_system.bo.BOFactory;
import com.ijse.gdse.railway_management.railway_management_system.bo.custom.PassengerBO;
import com.ijse.gdse.railway_management.railway_management_system.dto.PassengerDto;
import com.ijse.gdse.railway_management.railway_management_system.dto.tm.PassengerTM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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

    }

    @FXML
    void delete(ActionEvent event) {

    }

    @FXML
    void update(ActionEvent event) {

    }
}
