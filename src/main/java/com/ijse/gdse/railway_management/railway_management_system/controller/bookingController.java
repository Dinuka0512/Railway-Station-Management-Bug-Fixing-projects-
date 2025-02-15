package com.ijse.gdse.railway_management.railway_management_system.controller;

import com.ijse.gdse.railway_management.railway_management_system.util.crudUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class bookingController {

        @FXML
        private ComboBox<String> txtTrainID;

        @FXML
        private AnchorPane content;

        @FXML
        private TextField txtBookingID;

        @FXML
        private Hyperlink btnNext;

        @FXML
        private TextField txtUserID;

        @FXML
        private DatePicker dpBookingDate;

        @FXML
        private ComboBox<String> cmbFrom;

        @FXML
        private ComboBox<String> cmbTo;


        @FXML
        private TextField txtStatus;

        @FXML
        private TextField txtTotalFare;

        @FXML
        private ComboBox<String> cmbPassenger;

        @FXML
        private Button btnBook;

        @FXML
        private Button btnReset;

        // Initialize ComboBoxes
        @FXML
        public void initialize() {
            cmbFrom.getItems().addAll("Panadura", "Colombo", "Galle", "Kandy","maradana");
            cmbTo.getItems().addAll("Jaffna", "Matara", "Badulla", "Trincomalee","kalutara");
            cmbPassenger.getItems().addAll("1","2","3","4","5" );
        }

    @FXML
    void bookOnaction(ActionEvent event) {
            String bookingID = txtBookingID.getText();
            String userID = txtUserID.getText();
            String trainID = txtTrainID.getValue();
            String from = cmbFrom.getValue();
            String to = cmbTo.getValue();
            String status = txtStatus.getText();
            String totalFare = txtTotalFare.getText();
            int passengers = Integer.parseInt(cmbPassenger.getValue());

            if (bookingID.isEmpty() || userID.isEmpty() || trainID.isEmpty() || from == null || to == null || status.isEmpty() || totalFare.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Input Error", "Please fill in all fields!");
                return;
            }

            try {
                // Insert booking details into the database
                String sql = "INSERT INTO booking (b_id, b_date, user_id, tr_id, total_fare, status, from, to, no_of_passengers) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                boolean isBooked = crudUtil.execute(sql, bookingID, dpBookingDate.getValue(), userID, trainID, Double.parseDouble(totalFare), status, from, to, passengers);

                if (isBooked) {
                    showAlert(Alert.AlertType.INFORMATION, "Booking Successful", "Ticket booked successfully!");
                    resetForm();
                } else {
                    showAlert(Alert.AlertType.ERROR, "Booking Failed", "Failed to book the ticket. Try again.");
                }
            } catch (Exception e) {
                e.printStackTrace();
                showAlert(Alert.AlertType.ERROR, "Database Error", "An error occurred while booking the ticket.");
            }
        }

    @FXML
    void navigateToPayment(ActionEvent event) {

        try {
            Parent paymentView = FXMLLoader.load(getClass().getResource("/view/paymentView.fxml"));
            Stage stage = (Stage) content.getScene().getWindow();
            stage.setScene(new Scene(paymentView));
            stage.setTitle("Payment");
            stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                showAlert(Alert.AlertType.ERROR, "Navigation Error", "Failed to navigate to the payment screen.");
            }
        }

    @FXML
    void resetOnAction(ActionEvent event) {

        resetForm();
        }

        private void resetForm() {
            txtBookingID.clear();
            txtUserID.clear();
            txtTrainID.getSelectionModel().clearSelection();
            txtStatus.clear();
            txtTotalFare.clear();
            cmbFrom.getSelectionModel().clearSelection();
            cmbTo.getSelectionModel().clearSelection();
            cmbPassenger.getSelectionModel().clearSelection();;
            dpBookingDate.setValue(null);
        }

        private void showAlert(Alert.AlertType alertType, String title, String message) {
            Alert alert = new Alert(alertType);
            alert.setTitle(title);
            alert.setContentText(message);
            alert.showAndWait();
        }
    }





