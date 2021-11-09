package model;

public class User {
    private String name;
    private String icnumber;
    private String gender;
    private String address;
    private String state;
    private String poscode;
    private String city;
    private String DOB;
    private String role;

    public User(String name, String icnumber, String gender, String address, 
                String state, String poscode, String city,
                String DOB, String role){
        this.name = name;
        this.icnumber = icnumber;
        this.gender = gender;
        this.address = address;
        this.state = state;
        this.poscode = poscode;
        this.city = city;
        this.DOB = DOB;
        this.role = role;
    }

    public String getName(){
        return name;
    }

    public String getICnumber(){
        return icnumber;
    }

    public String getGender(){
        return gender;
    }

    public String getAddress(){
        return address;
    }

    public String getState(){
        return state;
    }

    public String getPoscode(){
        return poscode;
    }

    public String getCity(){
        return city;
    }

    public String getDOB(){
        return DOB;
    }

    public String getRole(){
        return role;
    }
}
