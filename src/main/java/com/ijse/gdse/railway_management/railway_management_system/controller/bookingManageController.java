package com.ijse.gdse.railway_management.railway_management_system.controller;

import javafx.event.ActionEvent;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import com.ijse.gdse.railway_management.railway_management_system.util.crudUtil;
import com.ijse.gdse.railway_management.railway_management_system.dto.tm.bookingTm;
import java.sql.ResultSet;
import java.sql.SQLException;

    public class bookingManageController {

        @FXML
        private TextField txtBookingID;

        @FXML
        private TextField txtUserID;

        @FXML
        private TextField txtTrainID;

        @FXML
        private TextField txtTotalFare;

        @FXML
        private TextField txtStatus;

        @FXML
        private TextField txtFrom;

        @FXML
        private TextField txtTo;

        @FXML
        private TextField txtPassengers;

        @FXML
        private DatePicker dpBookingDate;

        @FXML
        private TableView<bookingTm> tblBookings;

        @FXML
        private TableColumn<bookingTm, String> colBookingID;

        @FXML
        private TableColumn<bookingTm, String> colBookingDate;

        @FXML
        private TableColumn<bookingTm, String> colUserID;

        @FXML
        private TableColumn<bookingTm, Double> colTotalFare;

        @FXML
        private TableColumn<bookingTm, String> colStatus;

        @FXML
        private TableColumn<bookingTm, String> colTrainID;

        @FXML
        private TableColumn<bookingTm, String> colFrom;

        @FXML
        private TableColumn<bookingTm, String> colTo;

        @FXML
        private TableColumn<bookingTm, Integer>  colNoPasseng;;

        private final ObservableList<bookingTm> bookingList = FXCollections.observableArrayList();

        @FXML
        public void initialize() {
            // Configure table columns
            colBookingID.setCellValueFactory(new PropertyValueFactory<>("bookingID"));
            colBookingDate.setCellValueFactory(new PropertyValueFactory<>("bookingDate"));
            colUserID.setCellValueFactory(new PropertyValueFactory<>("userID"));
            colTotalFare.setCellValueFactory(new PropertyValueFactory<>("totalFare"));
            colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
            colTrainID.setCellValueFactory(new PropertyValueFactory<>("trainID"));
            colFrom.setCellValueFactory(new PropertyValueFactory<>("from"));
            colTo.setCellValueFactory(new PropertyValueFactory<>("to"));
            colNoPasseng.setCellValueFactory(new PropertyValueFactory<>("noOfPassengers"));

            loadAllBookings();
        }

        @FXML
        public void saveBookingOnAction(ActionEvent actionEvent) {
            String bookingID = txtBookingID.getText();
            String userID = txtUserID.getText();
            String trainID = txtTrainID.getText();
            String from = txtFrom.getText();
            String to = txtTo.getText();
            String status = txtStatus.getText();
            String totalFare = txtTotalFare.getText();
            String passengers = txtPassengers.getText();

            if (bookingID.isEmpty() || userID.isEmpty() || trainID.isEmpty() || from.isEmpty() || to.isEmpty() ||
                    status.isEmpty() || totalFare.isEmpty()  || passengers.isEmpty()) {
                showAlert(AlertType.ERROR, "Input Error", "Please fill in all fields!");
                return;
            }

            try {
                String sql = "INSERT INTO booking (b_id, b_date, user_id, tr_id, total_fare, status, from, to, no_of_passengers) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                boolean isSaved = crudUtil.execute(sql, bookingID, userID, trainID, Double.parseDouble(totalFare),
                        status, from, to, Integer.parseInt(passengers));

                if (isSaved) {
                    showAlert(AlertType.INFORMATION, "Booking Saved", "New booking added successfully!");
                    loadAllBookings();
                    clearForm();
                } else {
                    showAlert(AlertType.ERROR, "Save Failed", "Failed to add the booking. Try again.");
                }
            } catch (SQLException  e) {
                e.printStackTrace();
                showAlert(AlertType.ERROR, "Database Error", "An error occurred while saving the booking.");
            }
        }

        @FXML
        public void updateONAction(ActionEvent actionEvent) {
            String bookingID = txtBookingID.getText();
            String userID = txtUserID.getText();
            String trainID = txtTrainID.getText();
            String from = txtFrom.getText();
            String to = txtTo.getText();
            String status = txtStatus.getText();
            String totalFare = txtTotalFare.getText();
            String bookingDate = dpBookingDate.getValue() != null ? dpBookingDate.getValue().toString() : null;
            String passengers = txtPassengers.getText();

            if (bookingID.isEmpty()) {
                showAlert(AlertType.ERROR, "Input Error", "Booking ID is required for updating!");
                return;
            }

            try {
                String sql = "UPDATE booking SET b_date=?, user_id=?, tr_id=?, total_fare=?, status=?, from=?, to=?, no_of_passengers=? WHERE b_id=?";
                boolean isUpdated = crudUtil.execute(sql, bookingDate, userID, trainID, Double.parseDouble(totalFare),
                        status, from, to, Integer.parseInt(passengers), bookingID);

                if (isUpdated) {
                    showAlert(AlertType.INFORMATION, "Booking Updated", "Booking updated successfully!");
                    loadAllBookings();
                    clearForm();
                } else {
                    showAlert(AlertType.ERROR, "Update Failed", "Failed to update the booking. Try again.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                showAlert(AlertType.ERROR, "Database Error", "An error occurred while updating the booking.");
            }
        }

        @FXML
        public void deleteOnAction(ActionEvent actionEvent) {
            String bookingID = txtBookingID.getText();

            if (bookingID.isEmpty()) {
                showAlert(AlertType.ERROR, "Input Error", "Booking ID is required for deletion!");
                return;
            }

            try {
                String sql = "DELETE FROM booking WHERE b_id=?";
                boolean isDeleted = crudUtil.execute(sql, bookingID);

                if (isDeleted) {
                    showAlert(AlertType.INFORMATION, "Booking Deleted", "Booking deleted successfully!");
                    loadAllBookings();
                    clearForm();
                } else {
                    showAlert(AlertType.ERROR, "Delete Failed", "Failed to delete the booking. Try again.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                showAlert(AlertType.ERROR, "Database Error", "An error occurred while deleting the booking.");
            }
        }

        private void loadAllBookings() {
            bookingList.clear();
            try {
                ResultSet rs = crudUtil.execute("SELECT * FROM booking");
                while (rs.next()) {
                    bookingList.add(new bookingTm(
                            rs.getString("b_id"),
                            rs.getString("b_date"),
                            rs.getString("user_id"),
                            rs.getDouble("total_fare"),
                            rs.getString("status"),
                            rs.getString("tr_id"),
                            rs.getString("from"),
                            rs.getString("to"),
                            rs.getInt("no_of_passengers")
                    ));
                }
                tblBookings.setItems(bookingList);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void clearForm() {
            txtBookingID.clear();
            txtUserID.clear();
            txtTrainID.clear();
            txtTotalFare.clear();
            txtStatus.clear();
            txtFrom.clear();
            txtTo.clear();
            txtPassengers.clear();
            dpBookingDate.setValue(null);
        }

        private void showAlert(AlertType alertType, String title, String message) {
            Alert alert = new Alert(alertType);
            alert.setTitle(title);
            alert.setContentText(message);
            alert.showAndWait();
        }
    }

