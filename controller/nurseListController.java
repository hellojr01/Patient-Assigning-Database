package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.Node;

public class nurseListController {
    
    Stage primaryStage;
    Parent root;
    
    @FXML
    private Button name1;

    @FXML
    private Button name2;

    @FXML
    private Button name3;

    @FXML
    private Button name4;

    @FXML
    private Button name5;

    @FXML
    private Button name6;

    @FXML
    void switchToAdminView(ActionEvent event) throws IOException {
        loadFXML("/view/adminView.fxml", event);
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
