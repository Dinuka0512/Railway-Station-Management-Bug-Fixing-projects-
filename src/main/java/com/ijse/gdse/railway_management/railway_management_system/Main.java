package com.ijse.gdse.railway_management.railway_management_system;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
       try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/loginView.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Railway Management System");
            primaryStage.setScene(scene);
            primaryStage.show();
       } catch (IOException e) {
            System.out.println("IOException \n Unable to load Login view");
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws SQLException {
        launch(args);
    }
}
