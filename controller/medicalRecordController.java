package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import java.util.*;
import java.awt.Desktop;
import java.io.File;
import model.Database;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class medicalRecordController {
    Stage primaryStage;
    Parent root;

    @FXML
    private Button filename;

    @FXML
    private ArrayList<Button> file_list;

    @FXML
    void switchToDoctorView(ActionEvent event) throws IOException {
        loadFXML("/view/doctorView.fxml", event);
    }

    @FXML
    void openFile(ActionEvent event) {
        String filename = ((Button)event.getSource()).getText();
        try {
            File pdfFile = new File("Database/Report/" + filename + ".pdf");
            if (pdfFile.exists()) {
    
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    System.out.println("Awt Desktop is not supported!");
                }
    
            } else {
                System.out.println("File is not exists!");
            }
          } catch (Exception ex) {
            ex.printStackTrace();
          }
    }

    @FXML
    void uploadFile(ActionEvent event) {
        FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new ExtensionFilter("Files", Arrays.asList("*.pdf")));
            List<File> f = fc.showOpenMultipleDialog(null);
            for(File i:f){
                File source = new File(i.getAbsolutePath());
                File dest = new File("./Database/Report/" + i.getName());
                try
                {
                    Database.copyFileUsingStream(source, dest);
                    try{
                        displayAlert();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                catch (java.io.IOException ioe)
                {
                    System.out.println("File Copy Crash " + "./Database/Report/" + i.getName());
                }
        }
    }

    private void displayAlert() throws Exception {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("File Information");
        alert.setHeaderText("Information");
        alert.setContentText("File is uploaded successfully!");
        alert.showAndWait();
    }


    private void loadFXML(String fxmlPath,ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource(fxmlPath));
        primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }

}
