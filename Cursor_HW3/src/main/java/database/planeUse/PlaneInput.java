package database.planeUse;

import java.util.Scanner;
import model.Plane;

public class PlaneInput {
    private static Scanner scanner;

    public Plane addPlane() {
        scanner =  new Scanner(System.in);
        System.out.println("Введіть модель літака:");
        String model = scanner.nextLine();
        System.out.println("Введіть серійний номер літака:");
        String serialNumber = scanner.nextLine();
        System.out.println("Введіть кількість місць:");
        int seats = scanner.nextInt();
        Plane plane = new Plane(model, serialNumber, seats);
        return plane;
    }

    public Plane updatePlaneSeats() {
        scanner =  new Scanner(System.in);
        System.out.println("Введіть модель літака:");
        String model = scanner.nextLine();
        System.out.println("Введіть кількість місць:");
        int newSeats = scanner.nextInt();
        Plane plane = new Plane(model, "", newSeats);
        return plane;
    }

    public String deletePlane() {
        scanner =  new Scanner(System.in);
        System.out.println("Введіть серійний номер літака:");
        String serialNumber = scanner.nextLine();
        return serialNumber;
    }
}
