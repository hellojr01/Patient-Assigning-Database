package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.Node;

public class doctorViewController {
    
    Stage primaryStage;
    Parent root;
    
    @FXML
    void switchToLogin(ActionEvent event) throws IOException {
        loadFXML("/view/login.fxml", event);
    }

    @FXML
    void switchToMedicRecord(ActionEvent event) throws IOException {
        loadFXML("/view/medicalRecord.fxml", event);
    }

    @FXML
    void switchToPatientInfo(ActionEvent event) throws IOException {
        loadFXML("/view/patientInfo.fxml", event);
    }

    @FXML
    void switchToPatientDiagnosis(ActionEvent event) throws IOException {
        loadFXML("/view/patientDiagnosisView.fxml", event);
    }

    private void loadFXML(String fxmlPath,ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource(fxmlPath));
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }
}
