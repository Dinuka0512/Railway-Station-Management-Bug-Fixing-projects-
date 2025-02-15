package com.ijse.gdse.railway_management.railway_management_system.controller;

import com.ijse.gdse.railway_management.railway_management_system.dto.tm.trainManageTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class trainController {

    @FXML
    private TextField txtTrainId;

    @FXML
    private TextField txtTrainName;

    @FXML
    private ComboBox<?> txtTrainType;

    @FXML
    private TableView<trainManageTm> trainTable;

    @FXML
    private TableColumn<trainManageTm, String> colTrainId;

    @FXML
    private TableColumn<trainManageTm, String> colTrainName;

    @FXML
    private TableColumn<trainManageTm, String> colType;

    private ObservableList<trainManageTm> trainList = FXCollections.observableArrayList();  // List to hold train data

    @FXML
    public void initialize() {
        // Set cell value factories for the TableView columns
        colTrainId.setCellValueFactory(cellData -> cellData.getValue().trainIdProperty());
        colTrainName.setCellValueFactory(cellData -> cellData.getValue().trainNameProperty());
        colType.setCellValueFactory(cellData -> cellData.getValue().typeProperty());

        // Load data into the TableView
        trainTable.setItems(trainList);
    }

    @FXML
    void deleteTrainOnAction(ActionEvent event) {
        trainManageTm selectedTrain = trainTable.getSelectionModel().getSelectedItem();
        if (selectedTrain == null) {
            showAlert("Error", "Please select a train to delete!", Alert.AlertType.ERROR);
            return;
        }

        // Remove the selected train from the list
        trainList.remove(selectedTrain);
        showAlert("Success", "Train deleted successfully!", Alert.AlertType.INFORMATION);
    }


    @FXML
    void saveTrainOnAction(ActionEvent event) {
        String trainId = txtTrainId.getText();
        String trainName = txtTrainName.getText();
        String trainType = txtTrainType.getText();

        if (trainId.isEmpty() || trainName.isEmpty() || trainType.isEmpty()) {
            showAlert("Error", "All fields must be filled!", Alert.AlertType.ERROR);
            return;
        }

        // Create a new train object and add it to the list
        trainManageTm newTrain = new trainManageTm(trainId, trainName, trainType);
        trainList.add(newTrain);

        // Clear input fields after saving
        clearFields();

        showAlert("Success", "Train saved successfully!", Alert.AlertType.INFORMATION);
    }


    @FXML
    void updateTrainOnAction(ActionEvent event) {
        trainManageTm selectedTrain = trainTable.getSelectionModel().getSelectedItem();
        if (selectedTrain == null) {
            showAlert("Error", "Please select a train to update!", Alert.AlertType.ERROR);
            return;
        }

        // Get new values from input fields
        String trainId = txtTrainId.getText();
        String trainName = txtTrainName.getText();
        String trainType = txtTrainType.getText();

        if (trainId.isEmpty() || trainName.isEmpty() || trainType.isEmpty()) {
            showAlert("Error", "All fields must be filled!", Alert.AlertType.ERROR);
            return;
        }

        // Update train details
        selectedTrain.setTrainId(trainId);
        selectedTrain.setTrainName(trainName);
        selectedTrain.setType(trainType);

        // Refresh TableView
        trainTable.refresh();
        clearFields();

        showAlert("Success", "Train updated successfully!", Alert.AlertType.INFORMATION);
    }

    // Method to display alerts
    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Method to clear input fields
    private void clearFields() {
        txtTrainId.clear();
        txtTrainName.clear();
        txtTrainType.clear();
    }
    }
}




