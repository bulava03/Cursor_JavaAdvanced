package restaraunt;
import java.util.List;

public class Food {
    String name;
    Double price;
    public Food(String name, Double price){
        this.name = name;
        this.price = price;
    }
    public static void PrintPrices(List<Food> food) {
        int i = 1;
        for (Food element: food
        ) {
            System.out.println(Integer.toString(i) + ". " + element.name + " Ціна: " + Double.toString(element.price));
            i = i + 1;
        }
    }
}
