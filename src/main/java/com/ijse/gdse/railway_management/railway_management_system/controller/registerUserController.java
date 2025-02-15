package com.ijse.gdse.railway_management.railway_management_system.controller;

import com.ijse.gdse.railway_management.railway_management_system.dao.custom.impl.userDAOImpl;
import com.ijse.gdse.railway_management.railway_management_system.db.DBConnection;
import com.ijse.gdse.railway_management.railway_management_system.dto.tm.userTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class registerUserController {

    @FXML
    private TextField contactnofield;

    @FXML
    private TextField gmailField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField userIdField;


    @FXML
    private TableColumn<userTm, String> colGmail;

    @FXML
    private TableColumn<userTm, String> colName;

    @FXML
    private TableColumn<userTm, String> colUserId;

    @FXML
    private TableColumn<userTm, Integer> colcontact;

    private ObservableList<userTm> userList = FXCollections.observableArrayList();

    private userDAOImpl userModel = new userDAOImpl();

    @FXML
    void registerUsersONAction(ActionEvent event) {

    }
    @FXML
    public void initialize() {
        colUserId.setCellValueFactory(new PropertyValueFactory<>("userId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colcontact.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        colGmail.setCellValueFactory(new PropertyValueFactory<>("gmail"));
        loadUsers();
    }

    @FXML
    void registerUser(ActionEvent event) {
        String userId = userIdField.getText();
        String name = nameField.getText();
        int contactno = Integer.parseInt(contactnofield.getText());
        String gmail = gmailField.getText();

        if (userId.isEmpty() || name.isEmpty() || contactno.getText().isEmpty || gmail.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Please fill in all fields.");
            return;
        }

        try (Connection conn = DBConnection.getInstance().getConnection()) {
            String query = "INSERT INTO users (u_id, name, contact_no, gmail) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, userId);
            stmt.setString(2, name);
            stmt.setInt(3, contactno);
            stmt.setString(4, gmail);
            stmt.executeUpdate();

            userList.add(new userTm(userId, name, contactno, gmail));
            userTm.setItems(userList);

            clearFields();
            showAlert(Alert.AlertType.INFORMATION, "Success", "User registered successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Database Error", "Error registering user.");
        }
    }

    private void loadUsers() {
        userList.clear();
        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT * FROM users";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                userList.add(new userTm(
                        rs.getString("colUserId"),
                        rs.getString("colName"),
                        rs.getInt("colcontact"),
                        rs.getString("colGmail")
                ));
            }
            userTm.setItems(userList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void clearFields() {
        userIdField.clear();
        nameField.clear();
        contactnofield.clear();
        gmailField.clear();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.show();
    }

}
