package model;

public class Doctor extends User {
    private int roomNumber;
    public Doctor (String name, String icnumber, String gender, String address, 
                   String state, String poscode, String city,
                   String DOB, int roomNumber){
        super(name, icnumber, gender, address, state, poscode, city, DOB, "Doctor");
        this.roomNumber = roomNumber;
    }

    public int getRoomNumber(){
        return roomNumber;
    }
}
