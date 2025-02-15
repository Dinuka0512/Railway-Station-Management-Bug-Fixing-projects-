package com.ijse.gdse.railway_management.railway_management_system.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import lombok.Setter;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class sendMailController {

    @FXML
    private TextArea txtBody;

    @FXML
    private TextField txtSubject;

    @Setter
    private String gmail;

    private final String senderEmail = "akilapeiris92@gmail.com";  // Change to your email
    private final String senderPassword = "your-app-password"; // Generate App Password from Google


    public void sendUsingGmailOnAction(ActionEvent actionEvent) {

        if (gmail == null || gmail.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Email Error", "No recipient email provided.");
            return;
        }

        String subject = txtSubject.getText();
        String body = txtBody.getText();

        if (subject.isEmpty() || body.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Validation Error", "Subject and Body cannot be empty.");
            return;
        }

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(gmail));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);

            showAlert(Alert.AlertType.INFORMATION, "Success", "Email sent successfully.");
        } catch (MessagingException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Email Sending Failed", "Error: " + e.getMessage());
        }
    }


    public void sendUsingSendgridOnAction(ActionEvent actionEvent) {

        showAlert(Alert.AlertType.INFORMATION, "Coming Soon", "SendGrid email functionality will be implemented soon!");
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}



