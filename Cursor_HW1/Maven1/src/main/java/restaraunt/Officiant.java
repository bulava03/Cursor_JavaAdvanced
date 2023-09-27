package restaraunt;

import java.util.List;
import java.util.ArrayList;
public class Officiant {
    String first_name;
    String last_name;
    int num_of_orders;
    List<Integer> tables;
    public Officiant(String first_name, String last_name){
        this.first_name = first_name;
        this.last_name = last_name;
        this.num_of_orders = 0;
        this.tables = new ArrayList<Integer>();
    }
}
