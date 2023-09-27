package database.pilotUse;

import java.util.Scanner;
import model.Pilot;

public class PilotInput {
    private static Scanner scanner = new Scanner(System.in);

    public Pilot addPilot() {
        scanner =  new Scanner(System.in);
        System.out.println("Введіть ім'я пілота:");
        String name = scanner.nextLine();
        System.out.println("Введіть вік пілота:");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введіть назви моделей літаків, якими пілот може керувати (через кому):");
        String models = scanner.nextLine();
        Pilot pilot = new Pilot(name, age, models);
        return pilot;
    }

    public Pilot updatePilot() {
        scanner =  new Scanner(System.in);
        System.out.println("Введіть ім'я пілота, інформацію про якого хочете змінити:");
        String name = scanner.nextLine();
        System.out.println("Введіть назви моделей літаків, якими пілот може керувати (через кому):");
        String models = scanner.nextLine();
        Pilot pilot = new Pilot(name, 0, models);
        return pilot;
    }

    public String deletePilot() {
        scanner =  new Scanner(System.in);
        System.out.println("Введіть ім'я пілота:");
        String name = scanner.nextLine();
        return name;
    }
}
