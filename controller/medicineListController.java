package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.*;

public class medicineListController {

    @FXML
    private Label diagnosisText;

    @FXML
    private TextField medicineName;

    @FXML
    void addToList(ActionEvent event) {

    }

    @FXML
    void switchToMedicineReport(ActionEvent event) {
        loadFXML("/view/medicineReport.fxml", event);
    }

    private void loadFXML(String fxmlPath,ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource(fxmlPath));
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }

}
