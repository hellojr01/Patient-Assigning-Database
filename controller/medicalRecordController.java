package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.collections.FXCollections;

public class medicalRecordController {
    Stage primaryStage;
    Parent root;

    ObservableList<String> yearList = FXCollections.observableArrayList("2021","2020","2019","2018","2017");
    
    @FXML
    private ComboBox yearComboBox;

    @FXML
    private Label year;
    
    @FXML
    private void initialize() {
        yearComboBox.setValue("2021");
        yearComboBox.setItems(yearList);
    }

    @FXML
    void switchToDoctorView(ActionEvent event) throws IOException {
        loadFXML("/view/doctorView.fxml", event);
    }

    private void loadFXML(String fxmlPath,ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource(fxmlPath));
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }

}
