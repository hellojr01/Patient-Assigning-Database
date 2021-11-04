package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.Node;

public class adminViewController {
    Stage primaryStage;
    Parent root;
    
    @FXML
    void switchToDoctorList(ActionEvent event) throws IOException {
        loadFXML("/view/doctorList.fxml", event);
    }

    @FXML
    void switchToLogin(ActionEvent event) throws IOException {
        loadFXML("/view/login.fxml", event);
    }

    @FXML
    void switchToNurseList(ActionEvent event) throws IOException {
        loadFXML("/view/nurseList.fxml", event);
    }

    private void loadFXML(String fxmlPath,ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource(fxmlPath));
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }

}
