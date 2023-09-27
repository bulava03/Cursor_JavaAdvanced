package org.example;
import java.util.List;

public class OrderPrice {
    public static Double CountPrice(List<Food> list) {
        Double sum = 0.0;
        for (Food element : list
             ) {
            sum = sum + element.getPrice();
        }
        return sum;
    }
}
