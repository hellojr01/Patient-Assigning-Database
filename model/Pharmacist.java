package model;

public class Pharmacist extends User {
    public Pharmacist (String name, String icnumber, String gender, String address, 
                   String state, String poscode, String city,
                   String DOB, int roomNumber){
        super(name, icnumber, gender, address, state, poscode, city, DOB, "Pharmacist");
    }
}
