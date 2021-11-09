package model;

public class StaffNurse extends User{
    public StaffNurse (String name, String icnumber, String gender, String address, 
                   String state, String poscode, String city,
                   String DOB, int roomNumber){
        super(name, icnumber, gender, address, state, poscode, city, DOB, "Nurse");
    }
}
