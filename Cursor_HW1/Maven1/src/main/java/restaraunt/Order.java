package restaraunt;

import restaraunt.Food;

import java.util.List;
public class Order {
    public int table_number;
    public List<Food> food;
    public boolean status;
    public Double price;
    public Officiant officiant;
    public Order(int table_number, List<Food> food, Officiant officiant){
        this.table_number = table_number;
        this.food = food;
        this.status = false;
        this.price = CountPrice(food);
        this.officiant = officiant;
    }

    Double CountPrice(List<Food> food){
        Double final_price = 0.0;
        for (Food element: food
             ) {
            final_price = final_price + element.price;
        }
        return final_price;
    }
    public static void PrintOrders(List<Order> list) {
        for (Order element: list
        ) {
            System.out.println("=====================================================");
            System.out.println("Номер столика: " + Integer.toString(element.table_number));
            System.out.println("Офіціант: " + element.officiant.first_name + " " + element.officiant.last_name);
            System.out.println("Список замовлень: ");
            Food.PrintPrices(element.food);
            System.out.println("Загальна сума замовлення: " + Double.toString(element.price));
            System.out.println("=====================================================");
        }
    }
    public static void PrintPricesByOfficiant(List<Order> list, Officiant officiant) {
        Double sum = 0.0;
        for (Order element: list
        ) {
            if (element.officiant == officiant) {
                sum = sum + element.price;
            }
        }
        System.out.println("Сума вартойстей замовлень у офіціанта " + officiant.first_name + " " + officiant.last_name + ": " + Double.toString(sum));
    }
    public static void PrintSumOfPrices(List<Order> list) {
        Double sum = 0.0;
        for (Order element: list
        ) {
            sum = sum + element.price;
        }
        System.out.println("Сума вартостей усіх замовлень " + Double.toString(sum));
    }
}
