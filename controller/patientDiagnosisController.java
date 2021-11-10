package controller;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.Parent;
import javafx.stage.Stage;
import java.io.IOException;
import model.Database;

import java.util.ArrayList;
import java.util.List;

public class patientDiagnosisController {

    Stage primaryStage;
    Parent root;

    @FXML
    private TextArea diagnosisText;

    @FXML
    private Label name;

    @FXML
    void refreshInfo(ActionEvent event) {
        List<List<String>> patient_info = Database.readData("Patient");
        name.setText(patient_info.get(0).get(0));
    }

    @FXML
    void saveReason(ActionEvent event) {
        List<String> diagnosis = new ArrayList<>();
        diagnosis.add(diagnosisText.getText().toString());
        Database.writeData("PatientDiagnosis", diagnosis);
    }

    @FXML
    void switchToDoctorView(ActionEvent event) throws IOException {
        loadFXML("/view/doctorView.fxml", event);
    }

    @FXML
    void switchToLogin(ActionEvent event) throws IOException {
        loadFXML("/view/login.fxml", event);
    }

    private void loadFXML(String fxmlPath,ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource(fxmlPath));
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }

}
