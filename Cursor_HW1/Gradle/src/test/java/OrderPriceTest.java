import org.example.OrderPrice;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.util.ArrayList;
import org.example.Food;

public class OrderPriceTest {
    @Test
    public void testSum() {
        Food food1 = new Food();
        food1.setName("borshch");
        food1.setPrice(50.5);
        Food food2 = new Food();
        food2.setName("varenyky");
        food2.setPrice(30.0);
        List<Food> foodList = new ArrayList<Food>();
        foodList.add(food1);
        foodList.add(food2);
        assertEquals(80.5, OrderPrice.CountPrice(foodList));
    }
}
