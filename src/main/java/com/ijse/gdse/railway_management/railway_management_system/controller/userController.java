package com.ijse.gdse.railway_management.railway_management_system.controller;
import com.ijse.gdse.railway_management.railway_management_system.dao.custom.impl.userDAOImpl;
import com.ijse.gdse.railway_management.railway_management_system.db.DBConnection;
import com.ijse.gdse.railway_management.railway_management_system.dto.tm.userTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class userController {

    @FXML
    private TextField txtContactNo;

    @FXML
    private TextField txtGmail;

    @FXML
    private ComboBox<?> txtUserId;

    @FXML
    private TextField txtUserName;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableView<?> userTable;

    @FXML
    private TableColumn<userTm, Integer> colContactNo;

    @FXML
    private TableColumn<userTm, String> colGmail;

    @FXML
    private TableColumn<userTm, String> colUserId;

    @FXML
    private TableColumn<userTm, String> colUserName;


    private ObservableList<userTm> userList = FXCollections.observableArrayList();
    private userDAOImpl userModel = new userDAOImpl();

    @FXML
    public void initialize() {
        colUserId.setCellValueFactory(new PropertyValueFactory<>("userId"));
        colUserName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colContactNo.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        colGmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        loadUsers();
    }

    @FXML
    void deleteUserOnAction(ActionEvent event) {

        userTm selectedUser = userTable.getSelectionModel().getSelectedItem();
        if (selectedUser == null) {
            showAlert(Alert.AlertType.WARNING, "Selection Error", "Please select a user to delete.");
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {
            String query = "DELETE FROM users WHERE user_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, selectedUser.getU_id());
            int deleted = stmt.executeUpdate();

            if (deleted > 0) {
                userList.remove(selectedUser);
                userTable.refresh();
                showAlert(Alert.AlertType.INFORMATION, "Success", "User deleted successfully.");
            } else {
                showAlert(Alert.AlertType.ERROR, "Delete Failed", "User not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Database Error", "Error deleting user.");
        }
    }

    @FXML
    void saveUserOnAction(ActionEvent event) {
        String userId = txtUserId.getId();
        String name = txtUserName.getText();
        String email = txtGmail.getText();
        int contactNo;

        if (userId.isEmpty() || name.isEmpty() || txtContactNo.getText().isEmpty() || email.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Please fill in all fields.");
            return;
        }

        try {
            contactNo = Integer.parseInt(txtContactNo.getText());
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Contact number must be a valid integer.");
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {
            String query = "INSERT INTO users (user_id, name, contact_no, email) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, userId);
            stmt.setString(2, name);
            stmt.setInt(3, contactNo);
            stmt.setString(4, email);
            stmt.executeUpdate();

            userList.add(new userTm(userId, name, contactNo, email));
            userTable.setItems(userList);

            clearFields();
            showAlert(Alert.AlertType.INFORMATION, "Success", "User registered successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Database Error", "Error registering user.");
        }
    }


    @FXML
    void updateUserOnAction(ActionEvent event) {

        userTm selectedUser = userTable.getSelectionModel().getSelectedItem();
        if (selectedUser == null) {
            showAlert(Alert.AlertType.WARNING, "Selection Error", "Please select a user to update.");
            return;
        }

        String userId = txtUserId.getId();
        String name = txtUserName.getText();
        String email = txtGmail.getText();
        int contactNo;

        try {
            contactNo = Integer.parseInt(txtContactNo.getText());
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Contact number must be a valid integer.");
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {
            String query = "UPDATE users SET name = ?, contact_no = ?, email = ? WHERE user_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setInt(2, contactNo);
            stmt.setString(3, email);
            stmt.setString(4, userId);
            int updated = stmt.executeUpdate();

            if (updated > 0) {
                selectedUser.setName(name);
                selectedUser.setContact_no(contactNo);
                selectedUser.setGmail(email);
                userTable.refresh();
                showAlert(Alert.AlertType.INFORMATION, "Success", "User updated successfully.");
            } else {
                showAlert(Alert.AlertType.ERROR, "Update Failed", "No user found with the given ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Database Error", "Error updating user.");
        }
    }

private void loadUsers() {
    userList.clear();
    try {
        userList.addAll(userModel.getAllUsers());
        userTable.setItems(userList);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

private void clearFields() {
    txtUserId.clear();
    txtUserName.clear();
    txtContactNo.clear();
    txtGmail.clear();
}

private void showAlert(Alert.AlertType alertType, String title, String message) {
    Alert alert = new Alert(alertType);
    alert.setTitle(title);
    alert.setContentText(message);
    alert.show();
}

   }

  }





