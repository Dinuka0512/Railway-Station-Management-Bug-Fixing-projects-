package com.ijse.gdse.railway_management.railway_management_system.dto.tm;

import com.mysql.cj.conf.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class trainManageTm {
    private  String tr_id;
    private  String  tr_name;
    private  String type ;
    private  String booking_id;

    public trainManageTm(String trainId, String trainName, String type) {
        this.tr_id = new SimpleStringProperty(trainId);
        this.tr_name = new SimpleStringProperty(trainName);
        this.type = new SimpleStringProperty(type);
    }

    public StringProperty trainIdProperty() { return tr_id; }
    public StringProperty trainNameProperty() { return tr_name; }
    public StringProperty typeProperty() { return type; }

    public String getTrainId() { return tr_id.get(); }
    public void setTrainId(String value) { tr_id.set(value); }

    public String getTrainName() { return tr_name.get(); }
    public void setTrainName(String value) { tr_name.set(value); }

    public String getType() { return type.get(); }
    public void setType(String value) { type.set(value); }
}



