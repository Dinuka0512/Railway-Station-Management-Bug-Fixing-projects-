package com.ijse.gdse.railway_management.railway_management_system.controller;

import com.ijse.gdse.railway_management.railway_management_system.dao.custom.impl.paymentDAOImpl;
import com.ijse.gdse.railway_management.railway_management_system.dto.paymentDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.Optional;

public class paymentController {

    @FXML
    private TextField amount;

    @FXML
    private TableColumn<paymentDAOImpl, Double> colAmount;

    @FXML
    private TableColumn<paymentDAOImpl, String> colDate;

    @FXML
    private TableColumn<paymentDAOImpl, String> colMethod;

    @FXML
    private TableColumn<paymentDAOImpl, String> colPaymentId;

    @FXML
    private ComboBox<String> pMethod;

    @FXML
    private DatePicker paymentDate;

    @FXML
    private TextField paymentId;

    @FXML
    private TableView<paymentDAOImpl> paymentTable;

    private ObservableList<paymentDAOImpl> paymentList = FXCollections.observableArrayList();
    private paymentDAOImpl paymentModel = new paymentDAOImpl(); // Database operations

    @FXML
    public void initialize() {
        // Set up table columns
        colPaymentId.setCellValueFactory(new PropertyValueFactory<>("paymentId"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));
        colMethod.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));

        pMethod.setItems(FXCollections.observableArrayList("Cash", "Credit Card", "Debit Card", "Online Banking"));

        loadPaymentData();
    }

    private void loadPaymentData() {
        paymentList.clear();
        paymentList.addAll(paymentModel.getAllPayments());
        paymentTable.setItems(paymentList);
    }

    @FXML
    void backToMain(ActionEvent event) {

        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle("Exit Confirmation");
        confirmation.setHeaderText("Are you sure you want to return to the main menu?");
        Optional<ButtonType> result = confirmation.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            // Navigate to the main menu (assuming MainMenu.fxml exists)
            NavigationUtil.navigateTo("mainView.fxml", event);
        }
    }

    @FXML
    void confirmPayment(ActionEvent event) {

        try {
            String payId = paymentId.getText();
            String payMethod = pMethod.getValue();
            LocalDate payDate = paymentDate.getValue();
            double payAmount = Double.parseDouble(amount.getText());

            if (payId.isEmpty() || payMethod == null || payDate == null) {
                showAlert(Alert.AlertType.WARNING, "Validation Error", "All fields must be filled.");
                return;
            }

            paymentDto payment = new paymentDto(p_Id, amount, method, date.valueOf(payDate));

            if (paymentModel.addPayment(payment)) {
                paymentList.add(new paymentDAOImpl(p_Id, amount, method, date.valueOf(payDate)));
                showAlert(Alert.AlertType.INFORMATION, "Success", "Payment confirmed successfully.");
                clearFields();
            } else {
                showAlert(Alert.AlertType.ERROR, "Database Error", "Failed to confirm payment.");
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Input Error", "Invalid amount. Enter a valid number.");
        }
    }

    @FXML
    void openSendMailModel(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Send Email");
        alert.setHeaderText("Send payment confirmation via email.");
        alert.setContentText("Feature coming soon!");
        alert.showAndWait();
    }

    private void clearFields() {
        paymentId.clear();
        amount.clear();
        paymentDate.setValue(null);
        pMethod.setValue(null);
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    }







