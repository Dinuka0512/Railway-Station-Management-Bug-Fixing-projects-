module com.ijse.gdse.railway_management.railway_management_system {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires java.sql;
    requires net.sf.jasperreports.core;
    requires java.mail;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires mysql.connector.j;

    opens com.ijse.gdse.railway_management.railway_management_system.dto.tm to javafx.base;//important
    opens com.ijse.gdse.railway_management.railway_management_system.controller to javafx.fxml;
    exports com.ijse.gdse.railway_management.railway_management_system;
}