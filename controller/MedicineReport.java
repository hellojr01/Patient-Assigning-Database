package controller;

import javafx.event.ActionEvent;

public class medicineReportController {

    @FXML
    void refreshInfo(ActionEvent event) {

    }

    @FXML
    void switchToLogin(ActionEvent event) {
        loadFXML("/view/login.fxml", event);
    }

    @FXML
    void switchToMedicineList(ActionEvent event) {
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
