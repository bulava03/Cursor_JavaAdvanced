package App;

import java.util.Scanner;

import database.DefaultDatabase;
import database.planeUse.PlaneImplementation;
import database.pilotUse.PilotImplementation;
import model.Plane;
import model.Pilot;
import database.planeUse.PlaneInput;
import database.pilotUse.PilotInput;

public class Menu {
    private static void printMenu() {
        System.out.println("Меню:");
        System.out.println("1 - Імовірна максимальна кількість місць в аеропорту");
        System.out.println("2 - Список літаків");
        System.out.println("3 - Список пілотів");
        System.out.println("4 - Додати літак");
        System.out.println("5 - Додати пілота");
        System.out.println("6 - Змінити кількість місць в літаку");
        System.out.println("7 - Змінити список літаків, якими може керувати пілот");
        System.out.println("8 - Видалити літак");
        System.out.println("9 - Видалити пілота");
        System.out.println("10 - Завершити виконання програми");
        System.out.println("\nОберіть дію\n");
    }

    private static int getOption() {
        int option;

        Scanner scanner = new Scanner(System.in);

        try {
            option = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println(e);
            option = -1;
        }

        return option;
    }

    public static void runProgram() {
        boolean run = true;

        int option;

        DefaultDatabase database = new DefaultDatabase();
        database.createDefaultDB();

        PlaneImplementation planeImplementation = new PlaneImplementation();
        PilotImplementation pilotImplementation = new PilotImplementation();
        PlaneInput planeInput = new PlaneInput();
        PilotInput pilotInput = new PilotInput();

        while (run) {
            printMenu();
            option = getOption();

            try {
                switch (option) {
                    case 1:
                        database.getCapacity();
                        break;
                    case 2:
                        planeImplementation.getPlanes();
                        break;
                    case 3:
                        pilotImplementation.getPilots();
                        break;
                    case 4:
                        Plane addPlane = planeInput.addPlane();
                        planeImplementation.addPlane(addPlane);
                        break;
                    case 5:
                        Pilot addPilot = pilotInput.addPilot();
                        pilotImplementation.addPilot(addPilot);
                        break;
                    case 6:
                        Plane updPlane = planeInput.updatePlaneSeats();
                        planeImplementation.updatePlane(updPlane);
                        break;
                    case 7:
                        Pilot updPilot = pilotInput.updatePilot();
                        pilotImplementation.updatePilot(updPilot);
                        break;
                    case 8:
                        String delPlane = planeInput.deletePlane();
                        planeImplementation.deletePlane(delPlane);
                        break;
                    case 9:
                        String delPilot = pilotInput.deletePilot();
                        pilotImplementation.deletePilot(delPilot);
                        break;
                    case 10:
                        run = false;
                        break;
                    default:
                        System.out.println("Дані введено некоректно!");
                }
                } catch (Exception e) {
                System.out.println("Дані введено некоректно!");
            }
        }
    }
}
