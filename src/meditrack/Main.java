package meditrack;


import meditrack.Console.*;
import meditrack.Menu.HandleMenu;
import meditrack.Menu.Menu;

import java.util.Scanner;


public class Main {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        if (args.length > 0 && "--loadData".equalsIgnoreCase(args[0])) {
            CSVConsole.loadDataFromCsv();
        }
        while (true) {
            Menu.mainMenu();
            System.out.print("Choose: ");
            int choice;
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    HandleMenu.handleDoctorMenu();
                    break;

                case 2:
                    HandleMenu.handlePatientMenu();
                    break;

                case 3:
                    HandleMenu.handleAdminMenu();
                    break;

                case 4:
                    System.out.println("Exiting MediTrack...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

