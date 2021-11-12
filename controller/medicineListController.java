package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.*;
import java.io.IOException;
import model.Database;
import java.util.List;
import java.io.*;
import javafx.scene.control.Button;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class medicineListController {
    
    Stage primaryStage;
    Parent root;
    List<List<String>> list = new ArrayList<>();
    List<String> temp = new ArrayList<>();
    int index;
    

    @FXML
    private Button addButton;

    @FXML
    private Label diagnosisText;

    @FXML
    private TextField medicineName;

    @FXML
    private Label name;

    @FXML
    private Label medicine;

    public void initialize(){
        medicine.setVisible(false);
        addButton.setVisible(false);
        addButton.setDisable(true);
    }
    
    @FXML
    void refreshInfo(ActionEvent event) {
        List<List<String>> patient_info = Database.readData("Patient");
        name.setText(patient_info.get(0).get(0));
        try{  
            File file=new File("./Database/PatientDiagnosis.txt");    //creates a new file instance  
            FileReader fr=new FileReader(file);   //reads the file  
            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
            StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters  
            String line;  
            while((line=br.readLine())!=null)  
            {  
                sb.append(line);      //appends line to string buffer  
                sb.append("\n");     //line feed   
            }  
            fr.close();    //closes the stream and release the resources   
            diagnosisText.setText(sb.toString());   //returns a string that textually represents the object  
            }  
            catch(IOException e)  
            {  
                e.printStackTrace();  
            }   
        
    }

    // to search the medicine
    @FXML
    void search(ActionEvent event) {
        System.out.println("Search");
        boolean flag = false;
        List<List<String>> medicine_list = Database.readData("Medicine");
        for (int i = 0; i < medicine_list.size(); i++){
            // if medicine typed same as the name in csv file
            if (medicineName.getText().toString().equals(medicine_list.get(i).get(0))){
                index = i;
                medicine.setVisible(true);
                addButton.setVisible(true);
                addButton.setDisable(false);
                medicine.setText(medicine_list.get(i).get(0));
                flag = true;
            }
        }
        if (!flag){
            try{
                displayError();
            } catch (Exception e) {
                e.printStackTrace();
            }
            medicineName.setText(null);
        }
    }

    // to add into the patient's medicine list
    @FXML
    void addToList(ActionEvent event) {
        Database.writeTxtData("MedicineList", medicine.getText());
        try{
            displayAlert();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void switchToMedicineReport(ActionEvent event) throws IOException {
        loadFXML("/view/medicineReport.fxml", event);
    }

    private void displayError() throws Exception {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Input error");
        alert.setHeaderText("Error");
        alert.setContentText("Medicine not found");
        alert.showAndWait();
    }

    private void displayAlert() throws Exception {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Medicine Information");
        alert.setHeaderText("Information");
        alert.setContentText("Medicine is added successfully!");
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
