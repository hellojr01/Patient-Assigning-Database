package model;

public class Patient extends User{
    private int queueNumber;
    private int height;
    private int weight;

    public Patient(String name, String icnumber, String gender, String address, 
                   String state, String poscode, String city,
                   String DOB, int height, int weight){
        super(name, icnumber, gender, address, state, poscode, city, DOB, "Patient");
        this.height = height;
        this.weight = weight;
    }

    public int getHeight(){
        return height;
    }

    public int getWeight(){
        return weight;
    }

    public int getQueueNumber(){
        return queueNumber;
    }

    public void setQueueNumber(int queueNumber){
        this.queueNumber = queueNumber;
    }

}