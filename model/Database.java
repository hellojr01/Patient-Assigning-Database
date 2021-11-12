package model;

import java.util.*;

import javax.sound.midi.SysexMessage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;

public class Database{
  public static void writeData(String tableName, List<String> Entry){
    String fileName = tableName + ".txt";
    String filePath = "./Database/"+fileName;
    File csvFile = new File(filePath);
    if (csvFile.isFile()) {
        try{
            FileWriter pw = new FileWriter(filePath,true);
            //System.out.println("Writing " + fileName);
            for(int i = 0; i < Entry.size(); i++){
                  pw.append(Entry.get(i));
                  if(i == Entry.size() - 1){
                    pw.append("\n");
                  }
                  else{
                    pw.append(",");
                  }
            }
            pw.flush();
            pw.close();
        }
        catch(Exception e){
          e.printStackTrace();
        }
    }
    else{
      try{
          FileWriter pw = new FileWriter(filePath);
          for(int i = 0; i < Entry.size(); i++){
                pw.append(Entry.get(i));
                if(i == Entry.size() - 1){
                  pw.append("\n");
                }
                else{
                  pw.append(",");
                }
          }
          pw.flush();
          pw.close();
      }
      catch(Exception e){
        e.printStackTrace();
      }
    }
  }

  public static void writeTxtData(String tableName, String data){
    String fileName = tableName + ".txt";
    String filePath = "./Database/"+fileName;
    File csvFile = new File(filePath);
    if (csvFile.isFile()) {
        try{
            FileWriter pw = new FileWriter(filePath, true);
            System.out.println("Writing " + fileName);
            pw.append(data);
            pw.append('\n');
            pw.flush();
            pw.close();
        }
        catch(Exception e){
          e.printStackTrace();
        }
    }
    else{
      try{
        FileWriter pw = new FileWriter(filePath, true);
        System.out.println("Writing " + fileName);
        pw.append(data);
        pw.append('\n');
        pw.flush();
        pw.close();
    }
    catch(Exception e){
      e.printStackTrace();
    }
    }
  }

  public static List<List<String>> readData(String tableName){
    String fileName = tableName + ".csv";
    String filePath = "./Database/"+fileName;
    File csvFile = new File(filePath);
    List<List<String>> table = new ArrayList<List<String>>();
    if (csvFile.isFile()) {
        try{
            String row = null;
            BufferedReader csvReader = new BufferedReader(new FileReader(filePath));
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                List<String> temp = Arrays.asList(data);
                table.add(temp);
            }
            csvReader.close();
        }
        catch(Exception e){
          e.printStackTrace();
        }
    }
    return table;
  }

  public static List<List<String>> readTextData(String tableName){
    String fileName = tableName + ".txt";
    String filePath = "./Database/"+fileName;
    File csvFile = new File(filePath);
    List<List<String>> table = new ArrayList<List<String>>();
    if (csvFile.isFile()) {
        try{
            String row = null;
            BufferedReader csvReader = new BufferedReader(new FileReader(filePath));
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                List<String> temp = Arrays.asList(data);
                table.add(temp);
            }
            csvReader.close();
        }
        catch(Exception e){
          e.printStackTrace();
        }
    }
    return table;
  }

  public static void copyFileUsingStream(File source, File dest) throws IOException {
    InputStream is = null;
    OutputStream os = null;
    try {
        is = new FileInputStream(source);
        os = new FileOutputStream(dest);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = is.read(buffer)) > 0) {
            os.write(buffer, 0, length);
        }
    } finally {
        is.close();
        os.close();
    }
  }
}
