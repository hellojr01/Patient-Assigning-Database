package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import java.util.List;
import java.io.IOException;
import javafx.scene.Parent;
import model.Database;
import javafx.scene.control.Label;

public class medicineReportController {
    
    Stage primaryStage;
    Parent root;

    @FXML
    private Label address;

    @FXML
    private Label dob;

    @FXML
    private Label name;
    
    @FXML
    void refreshInfo(ActionEvent event) {
        List<List<String>> patient_info = Database.readData("Patient");
        name.setText(patient_info.get(0).get(0));
        address.setText(patient_info.get(0).get(9) + "," + patient_info.get(0).get(7) + " " + patient_info.get(0).get(6) + "," + patient_info.get(0).get(8));
        dob.setText(patient_info.get(0).get(5));
    }

    @FXML
    void switchToLogin(ActionEvent event) throws IOException {
        loadFXML("/view/login.fxml", event);
    }

    @FXML
    void switchToMedicineList(ActionEvent event) throws IOException {
        loadFXML("/view/medicineList.fxml", event);
    }

    private void loadFXML(String fxmlPath,ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource(fxmlPath));
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }

}
