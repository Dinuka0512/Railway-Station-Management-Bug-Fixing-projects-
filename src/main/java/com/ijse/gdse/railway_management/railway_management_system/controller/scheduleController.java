package com.ijse.gdse.railway_management.railway_management_system.controller;

import com.ijse.gdse.railway_management.railway_management_system.dto.tm.scheduleTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

public class scheduleController {

    @FXML
    private TableView<scheduleTm> scheduleTable;

    @FXML
    private TextField txtArrival;

    @FXML
    private TextField txtDeparture;

    @FXML
    private TextField txtDestination;

    @FXML
    private TextField txtScheduleId;

    @FXML
    private TextField txtStartStation;

    @FXML
    private TextField txtTrainId;

    @FXML
    private DatePicker txtTravelDate;


    @FXML
    private TableColumn<scheduleTm, Time> colArrival;

    @FXML
    private TableColumn<scheduleTm, Date> colDate;

    @FXML
    private TableColumn<scheduleTm,Time > colDeparture;

    @FXML
    private TableColumn<scheduleTm, String> colDestination;

    @FXML
    private TableColumn<scheduleTm,String > colScheduleId;

    @FXML
    private TableColumn<scheduleTm,String > colTrainId;

    @FXML
    private TableColumn<scheduleTm,String > colstartPoint;

    private ObservableList<scheduleTm> scheduleList = FXCollections.observableArrayList();
    private scheduleModel scheduleModel = new scheduleModel(); // Database operations

    @FXML
    public void initialize() {
        // Set up table columns
        colScheduleId.setCellValueFactory(new PropertyValueFactory<>("scheduleId"));
        colTrainId.setCellValueFactory(new PropertyValueFactory<>("trainId"));
        colstartPoint.setCellValueFactory(new PropertyValueFactory<>("startStation"));
        colDestination.setCellValueFactory(new PropertyValueFactory<>("destination"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("travelDate"));
        colDeparture.setCellValueFactory(new PropertyValueFactory<>("departureTime"));
        colArrival.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));

        loadScheduleData();
    }

    private void loadScheduleData() {
        scheduleList.clear();
        scheduleList.addAll(scheduleModel.getAllSchedules());
        scheduleTable.setItems(scheduleList);
    }


    @FXML
    void deleteScheduleOnAction(ActionEvent event) {

        scheduleTm selectedSchedule = scheduleTable.getSelectionModel().getSelectedItem();

        if (selectedSchedule == null) {
            showAlert(Alert.AlertType.WARNING, "No Selection", "Please select a schedule to delete.");
            return;
        }

        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle("Confirm Deletion");
        confirmation.setHeaderText("Are you sure you want to delete this schedule?");
        Optional<ButtonType> result = confirmation.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            if (scheduleModel.deleteSchedule(selectedSchedule.getScheduleId())) {
                scheduleList.remove(selectedSchedule);
                showAlert(Alert.AlertType.INFORMATION, "Success", "Schedule deleted successfully.");
            } else {
                showAlert(Alert.AlertType.ERROR, "Database Error", "Failed to delete schedule.");
            }
        }
    }



    @FXML
    void saveScheduleOnAction(ActionEvent event) {

        try {
            String scheduleId = txtScheduleId.getText();
            String trainId = txtTrainId.getText();
            String startStation = txtStartStation.getText();
            String destination = txtDestination.getText();
            LocalDate travelDate = txtTravelDate.getValue();
            LocalTime departureTime = LocalTime.parse(txtDeparture.getText());
            LocalTime arrivalTime = LocalTime.parse(txtArrival.getText());

            if (scheduleId.isEmpty() || trainId.isEmpty() || startStation.isEmpty() || destination.isEmpty() || travelDate == null) {
                showAlert(Alert.AlertType.WARNING, "Validation Error", "All fields must be filled.");
                return;
            }

            scheduleTm schedule = new scheduleTm(scheduleId, trainId, startStation, destination, Date.valueOf(travelDate), Time.valueOf(departureTime), Time.valueOf(arrivalTime));

            if (scheduleModel.addSchedule(schedule)) {
                scheduleList.add(schedule);
                showAlert(Alert.AlertType.INFORMATION, "Success", "Schedule added successfully.");
                clearFields();
            } else {
                showAlert(Alert.AlertType.ERROR, "Database Error", "Failed to add schedule.");
            }
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Input Error", "Invalid time format.");
        }
    }

    @FXML
    void updateScheduleOnAction(ActionEvent event) {

        scheduleTm selectedSchedule = scheduleTable.getSelectionModel().getSelectedItem();

        if (selectedSchedule == null) {
            showAlert(Alert.AlertType.WARNING, "No Selection", "Please select a schedule to update.");
            return;
        }

        try {
            String newTrainId = txtTrainId.getText();
            String newStartStation = txtStartStation.getText();
            String newDestination = txtDestination.getText();
            LocalDate newTravelDate = txtTravelDate.getValue();
            LocalTime newDepartureTime = LocalTime.parse(txtDeparture.getText());
            LocalTime newArrivalTime = LocalTime.parse(txtArrival.getText());

            if (newTrainId.isEmpty() || newStartStation.isEmpty() || newDestination.isEmpty() || newTravelDate == null) {
                showAlert(Alert.AlertType.WARNING, "Validation Error", "All fields must be filled.");
                return;
            }

            scheduleTm updatedSchedule = new scheduleTm(
                    selectedSchedule.getScheduleId(), newTrainId, newStartStation, newDestination,
                    Date.valueOf(newTravelDate), Time.valueOf(newDepartureTime), Time.valueOf(newArrivalTime)
            );

            if (scheduleModel.updateSchedule(updatedSchedule)) {
                int index = scheduleList.indexOf(selectedSchedule);
                scheduleList.set(index, updatedSchedule);
                showAlert(Alert.AlertType.INFORMATION, "Success", "Schedule updated successfully.");
                clearFields();
            } else {
                showAlert(Alert.AlertType.ERROR, "Database Error", "Failed to update schedule.");
            }
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Input Error", "Invalid time format.");
        }
    }

private void clearFields() {
    txtScheduleId.clear();
    txtTrainId.clear();
    txtStartStation.clear();
    txtDestination.clear();
    txtTravelDate.setValue(null);
    txtDeparture.clear();
    txtArrival.clear();
}

private void showAlert(Alert.AlertType type, String title, String message) {
    Alert alert = new Alert(type);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
}
}



