import model.Patient;
import java.util.*;

public class Test {
    public static void main(String[] args){
        Patient p1 =  new Patient("Lee Jia Rou", "011029080096", "Female", "Taman Pantai Jaya", "Perak", "34900", "Pantai Remis", "29/10/2001", 160, 40);
        System.out.println(p1.getAddress());    
    }
}
