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

public class medicineListController {
    
    Stage primaryStage;
    Parent root;

    @FXML
    private Label diagnosisText;

    @FXML
    private TextField medicineName;

    @FXML
    private Label name;

    @FXML
    void addToList(ActionEvent event) {

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

    @FXML
    void switchToMedicineReport(ActionEvent event) throws IOException {
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
