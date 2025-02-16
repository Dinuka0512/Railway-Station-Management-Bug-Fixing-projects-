package com.ijse.gdse.railway_management.railway_management_system.controller;

import com.ijse.gdse.railway_management.railway_management_system.dto.tm.PassengerTM;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        loadTable();
    }

    private void loadTable() {

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
