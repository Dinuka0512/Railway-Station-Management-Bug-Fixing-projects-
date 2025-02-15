package com.ijse.gdse.railway_management.railway_management_system.controller;

import com.ijse.gdse.railway_management.railway_management_system.dto.tm.promotionTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

public class promotionController {

    @FXML
    private DatePicker endDate;

    @FXML
    private DatePicker startDate;

    @FXML
    private TextField txtBookingId;

    @FXML
    private TextArea txtDescription;

    @FXML
    private TextField txtPromotionId;

    @FXML
    private TextField txtPromotionName;

    @FXML
    private TableView<promotionTm> promotionTable;

    @FXML
    private TableColumn<promotionTm, String> colBId;

    @FXML
    private TableColumn<promotionTm, String> colDescription;

    @FXML
    private TableColumn<promotionTm, Date> colEnd;

    @FXML
    private TableColumn<promotionTm, String> colPrId;

    @FXML
    private TableColumn<promotionTm, String> colPrName;

    @FXML
    private TableColumn<promotionTm, Date> colStart;

    private ObservableList<promotionTm> promotionList = FXCollections.observableArrayList();
    private promotionModel promotionModel = new promotionModel(); // Database operations

    @FXML
    public void initialize() {
        // Set up table columns
        colPrId.setCellValueFactory(new PropertyValueFactory<>("promotionId"));
        colPrName.setCellValueFactory(new PropertyValueFactory<>("promotionName"));
        colBId.setCellValueFactory(new PropertyValueFactory<>("bookingId"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colStart.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        colEnd.setCellValueFactory(new PropertyValueFactory<>("endDate"));

        loadPromotionData();
    }

    private void loadPromotionData() {
        promotionList.clear();
        promotionList.addAll(promotionModel.getAllPromotions());
        promotionTable.setItems(promotionList);
    }



    public void updatePromotionOnAction(ActionEvent actionEvent) {

        promotionTm selectedPromotion = promotionTable.getSelectionModel().getSelectedItem();

        if (selectedPromotion == null) {
            showAlert(Alert.AlertType.WARNING, "No Selection", "Please select a promotion to update.");
            return;
        }

        try {
            String newPromotionName = txtPromotionName.getText();
            String newBookingId = txtBookingId.getText();
            String newDescription = txtDescription.getText();
            LocalDate newStart = startDate.getValue();
            LocalDate newEnd = endDate.getValue();

            if (newPromotionName.isEmpty() || newBookingId.isEmpty() || newDescription.isEmpty() || newStart == null || newEnd == null) {
                showAlert(Alert.AlertType.WARNING, "Validation Error", "All fields must be filled.");
                return;
            }

            if (newStart.isAfter(newEnd)) {
                showAlert(Alert.AlertType.ERROR, "Date Error", "Start date must be before the end date.");
                return;
            }

            promotionTm updatedPromotion = new promotionTm(
                    selectedPromotion.getPromotionId(), newPromotionName, newBookingId, newDescription, Date.valueOf(newStart), Date.valueOf(newEnd)
            );

            if (promotionModel.updatePromotion(updatedPromotion)) {
                int index = promotionList.indexOf(selectedPromotion);
                promotionList.set(index, updatedPromotion);
                showAlert(Alert.AlertType.INFORMATION, "Success", "Promotion updated successfully.");
                clearFields();
            } else {
                showAlert(Alert.AlertType.ERROR, "Database Error", "Failed to update promotion.");
            }
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Input Error", "Invalid input.");
        }
    }

    public void savePromotionOnAction(ActionEvent actionEvent) {

        try {
            String promotionId = txtPromotionId.getText();
            String promotionName = txtPromotionName.getText();
            String bookingId = txtBookingId.getText();
            String description = txtDescription.getText();
            LocalDate start = startDate.getValue();
            LocalDate end = endDate.getValue();

            if (promotionId.isEmpty() || promotionName.isEmpty() || bookingId.isEmpty() || description.isEmpty() || start == null || end == null) {
                showAlert(Alert.AlertType.WARNING, "Validation Error", "All fields must be filled.");
                return;
            }

            if (start.isAfter(end)) {
                showAlert(Alert.AlertType.ERROR, "Date Error", "Start date must be before the end date.");
                return;
            }

            promotionTm promotion = new promotionTm(promotionId, promotionName, bookingId, description, Date.valueOf(start), Date.valueOf(end));

            if (promotionModel.addPromotion(promotion)) {
                promotionList.add(promotion);
                showAlert(Alert.AlertType.INFORMATION, "Success", "Promotion added successfully.");
                clearFields();
            } else {
                showAlert(Alert.AlertType.ERROR, "Database Error", "Failed to add promotion.");
            }
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Input Error", "Invalid input.");
        }
    }

    public void deletePromotionOnAction(ActionEvent actionEvent) {

        promotionTm selectedPromotion = promotionTable.getSelectionModel().getSelectedItem();

        if (selectedPromotion == null) {
            showAlert(Alert.AlertType.WARNING, "No Selection", "Please select a promotion to delete.");
            return;
        }

        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle("Confirm Deletion");
        confirmation.setHeaderText("Are you sure you want to delete this promotion?");
        Optional<ButtonType> result = confirmation.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            if (promotionModel.deletePromotion(selectedPromotion.getPromotionId())) {
                promotionList.remove(selectedPromotion);
                showAlert(Alert.AlertType.INFORMATION, "Success", "Promotion deleted successfully.");
            } else {
                showAlert(Alert.AlertType.ERROR, "Database Error", "Failed to delete promotion.");
            }
        }
    }
    private void clearFields() {
        txtPromotionId.clear();
        txtPromotionName.clear();
        txtBookingId.clear();
        txtDescription.clear();
        startDate.setValue(null);
        endDate.setValue(null);
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
