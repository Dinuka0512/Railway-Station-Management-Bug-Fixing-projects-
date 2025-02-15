package com.ijse.gdse.railway_management.railway_management_system.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import com.ijse.gdse.railway_management.railway_management_system.dto.registerAdminDto;
import com.ijse.gdse.railway_management.railway_management_system.dao.custom.impl.adminDAOImpl;
import java.io.IOException;
import java.sql.SQLException;

public class adminController {

    @FXML
    private TextField contactNoField;

    @FXML
    private AnchorPane content;

    @FXML
    private TextField gmailtext;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField userNameField;

    @FXML
    private String password;

    @FXML
    void gotoLogin(ActionEvent event) {
    }

    @FXML
    void register(ActionEvent event) {

    }
adminDAOImpl adminModel = new adminDAOImpl();

    @FXML
    void LoginMouseClickAction(MouseEvent event) throws IOException {
        content.getChildren().clear();
        AnchorPane load = FXMLLoader.load(getClass().getResource("/View/loginView.fxml"));
        content.getChildren().add(load);

        load.prefWidthProperty().bind(content.widthProperty());
        load.prefHeightProperty().bind(content.heightProperty());

        AnchorPane.setTopAnchor(load, 0.0);
        AnchorPane.setRightAnchor(load, 0.0);
        AnchorPane.setBottomAnchor(load, 0.0);
        AnchorPane.setLeftAnchor(load, 0.0);
    }

    @FXML
    void  registerOnAction(ActionEvent event) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("register button clicked");

        String username = userNameField.getText();
        String password = passwordField.getText();
        String gmail = gmailtext.getText();
        int contact_no = Integer.parseInt(contactNoField.getText());


        registerAdminDto registerAdminDto = new registerAdminDto(
                username,
                password,
                contact_no,
                gmail
        );

        boolean isSaved = adminModel.saveUser(registerAdminDto);
        if (isSaved) {
            new Alert(Alert.AlertType.INFORMATION, "Registration Complete.Please login...!").show();

            content.getChildren().clear();
            AnchorPane load = FXMLLoader.load(getClass().getResource("/view/registerAdmin.fxml"));
            content.getChildren().add(load);

        } else {
            new Alert(Alert.AlertType.ERROR, "Fail to register...!").show();
        }
    }


}

































