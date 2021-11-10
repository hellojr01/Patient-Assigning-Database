package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import java.io.IOException;
import javafx.scene.Parent;

public class medicineReportController {
    
    Stage primaryStage;
    Parent root;
    
    @FXML
    void refreshInfo(ActionEvent event) {
        
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
