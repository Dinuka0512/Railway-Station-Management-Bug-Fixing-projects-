package com.ijse.gdse.railway_management.railway_management_system.controller;

import com.ijse.gdse.railway_management.railway_management_system.db.DBConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.ijse.gdse.railway_management.railway_management_system.dao.custom.impl.loginDAOImpl;
public class loginController {

    public loginController() {
        System.out.println("loginController initialized!");
    }
    
    @FXML
    private AnchorPane content;

    @FXML
    private PasswordField password;

    @FXML
    private TextField usernameTxt;


    @FXML
    private Button btnLogin;

    private final loginDAOImpl login = new loginDAOImpl();

    @FXML
        public void btnLogin_OnAction(javafx.event.ActionEvent actionEvent) {

        try{
            String usernametxt = usernameTxt.getText();
            String passwordtxt = password.getText();

            String username =login.getUserName(usernametxt);


            if (usernametxt.equals(username)){
                String password= login.getPassword(passwordtxt,username);
               if(password != null){
                   if(password.equals(passwordtxt)){
                       try {
                           content.getChildren().clear();
                           AnchorPane load = FXMLLoader.load(getClass().getResource("/view/mainView.fxml"));
                           content.getChildren().add(load);
                       } catch (IOException e) {
                           e.printStackTrace();
                       }


                   }else {
                       new Alert(Alert.AlertType.ERROR,"password is incorrect").show();
                   }
               }else {
                   new Alert(Alert.AlertType.ERROR,"password is incorrect").show();
               }
            }else {
                new Alert(Alert.AlertType.ERROR,"invalid username").show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * Validate the username and password against the admin table in the database.
     *
     * @param username The username input by the user.
     * @param password The password input by the user.
     * @return true if the credentials match an admin record, otherwise false.
     */
    private boolean validateAdminLogin(String username, String password) {
        String query = "SELECT COUNT(*) FROM admin WHERE  username = ? AND  password = ?";
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next() && resultSet.getInt(1) > 0) {
                    return true; // Admin credentials are valid
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Database Error");
            alert.setContentText("An error occurred while validating login credentials.");
            alert.showAndWait();
        }
        return false; // Admin credentials are invalid
    }

    @FXML
    void btnOnAction(ActionEvent event) {
    }
    @FXML
    public void btnOnAction(javafx.event.ActionEvent actionEvent) {
    }


    public void navigateToRegister(javafx.event.ActionEvent actionEvent) {
        navigateTo("/view/registerAdmin.fxml");
    }

    public void navigateTo(String fxmlPath) {
        try {
            content.getChildren().clear();
            AnchorPane load = FXMLLoader.load(getClass().getResource(fxmlPath));

//  -------- Loaded anchor edges are bound to the content anchor --------
//      (1) Bind the loaded FXML to all edges of the content anchorPane
            load.prefWidthProperty().bind(content.widthProperty());
            load.prefHeightProperty().bind(content.heightProperty());

//      (2) Bind the loaded FXML to all edges of the AnchorPane
//            AnchorPane.setTopAnchor(load, 0.0);
//            AnchorPane.setRightAnchor(load, 0.0);
//            AnchorPane.setBottomAnchor(load, 0.0);
//            AnchorPane.setLeftAnchor(load, 0.0);

            content.getChildren().add(load);
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Fail to load page!").show();
        }
    }


}




