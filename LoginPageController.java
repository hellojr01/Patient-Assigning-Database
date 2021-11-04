package controller;

import java.util.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.*;
import java.io.IOException;
import javafx.scene.control.ComboBox;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Database;

public class LoginPageController {
    Stage primaryStage;
    Parent root;
    
    ObservableList<String> roleList = FXCollections.observableArrayList("Doctor","Nurse");

    @FXML
    private TextField userInput_ID;

    @FXML
    private PasswordField userInput_Password;

    @FXML
    private ComboBox roleComboBox;

    @FXML
    private void initialize() {
        roleComboBox.setValue("Doctor");
        roleComboBox.setItems(roleList);
    }


    @FXML
    void validate(ActionEvent event) throws Exception {
        boolean flag = false;
        flag = adminLogin(event);
        
        List<List<String>> list = Database.readData(roleComboBox.getValue().toString());
        for (int i = 0; i < list.size(); i++) {
            // to check whether ID and password are matched or not 
            if (list.get(i).get(0).equals(userInput_ID.getText()) && (list.get(i).get(1).equals(userInput_Password.getText()))) {
                flag = true;
        
        if (roleComboBox.getValue().toString().equals("Doctor")){
                loadFXML("/view/doctorView.fxml",event);
                flag = true;
        }
        else{
            loadFXML("/view/staffNurseView.fxml",event);
            flag = true;
        }
            }
        }
        if (!flag) {
            try {
                displayError();
                userInput_ID.setText(null);
                userInput_Password.setText(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private void displayError() throws Exception {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Input error");
        alert.setHeaderText("Error");
        alert.setContentText("Invalid ID or password");
        alert.showAndWait();
    }

    private void loadFXML(String fxmlPath,ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource(fxmlPath));
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }

    private boolean adminLogin(ActionEvent event) throws IOException {
        if (userInput_ID.getText().equals("admin") && userInput_Password.getText().equals("admin")){
            loadFXML("/view/adminView.fxml",event);
            return true;
        }
        return false;
    }
}