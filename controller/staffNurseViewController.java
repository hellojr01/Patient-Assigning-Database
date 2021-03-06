package controller;

import java.util.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.*;
import model.Database;


public class staffNurseViewController {
    Stage primaryStage;
    Parent root;
    List<String> reason = new ArrayList<>();

    @FXML
    private Label address;

    @FXML
    private Label patientName;

    @FXML
    private TextField reasonField;
    
    @FXML
    void switchToLogin(ActionEvent event) throws IOException {
        loadFXML("/view/login.fxml", event);
    }

    @FXML
    void saveReason(ActionEvent event){
        reason.add(reasonField.getText());
        Database.writeData("Patient_reason",reason);
    }

    @FXML
    void refreshInfo(ActionEvent event) {
        List<List<String>> patient_info = Database.readData("Patient");
        patientName.setText(patient_info.get(0).get(0));
        address.setText(patient_info.get(0).get(9) + "," + patient_info.get(0).get(7) + " " + patient_info.get(0).get(6) + "," + patient_info.get(0).get(8));
    }

    private void loadFXML(String fxmlPath,ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource(fxmlPath));
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }

}
