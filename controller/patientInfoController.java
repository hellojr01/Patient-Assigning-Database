package controller;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.*;
import java.util.*;
import model.Database;

public class patientInfoController {
    Stage primaryStage;
    Parent root;

    @FXML
    private Label reasonField;

    @FXML
    private Label address;

    @FXML
    private Label city;

    @FXML
    private Label dob;

    @FXML
    private Label gender;

    @FXML
    private Label height;

    @FXML
    private Label icNumber;

    @FXML
    private Label name;

    @FXML
    private Label poscode;

    @FXML
    private Label state;

    @FXML
    private Label weight;

    @FXML
    private ArrayList<Label> info_list;

    
    @FXML
    void switchToDoctorView(ActionEvent event) throws IOException {
        //reasonField.setText(null);
        loadFXML("/view/doctorView.fxml", event);
    }

    @FXML
    void refreshInfo(ActionEvent event){
        List<List<String>> patient_info = Database.readData("Patient");
        for (int i = 0; i < patient_info.size(); i++){
            info_list.get(i).setText(patient_info.get(i).get(i));
        }

    }

    private void loadFXML(String fxmlPath,ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource(fxmlPath));
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }

}
