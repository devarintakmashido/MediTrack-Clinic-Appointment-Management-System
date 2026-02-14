package meditrack.Menu;

import java.io.Console;
import java.util.Scanner;

import meditrack.Console.*;

public class HandleMenu {

    static Scanner sc = new Scanner(System.in);

    public static void handlePatientMenu() {

        while (true) {

            Menu.patientMenu();  // your existing print method
            System.out.print("Choose: ");

            try {

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        AppointmentConsole.bookAppointment();
                        break;

                    case 2:
                        AppointmentConsole.cancelAppointment();
                        break;

                    case 3:
                        DoctorConsole.listDoctors();
                        break;

                    case 4:
                        BillConsole.generateAndPayBill();
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid option.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static void handleDoctorMenu() {

        while (true) {
            Menu.doctorMenu();   // your existing print method
            System.out.print("Choose: ");
            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        PatientConsole.searchPatient();
                        break;
                    case 2:
                        AppointmentConsole.cancelAppointment();
                        break;
                    case 3:
                        return;   // exit doctor menu
                    default:
                        System.out.println("Invalid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static void handleAdminMenu(){

        while (true) {

            Menu.adminMenu();
            System.out.print("Choose: ");

            try {

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        DoctorConsole.addDoctor();
                        break;
                    case 2:
                        PatientConsole.addPatient();
                        break;
                    case 3:
                        AppointmentConsole.bookAppointment();
                        break;
                    case 4:
                        AppointmentConsole.cancelAppointment();
                        break;
                    case 5:
                        BillConsole.generateAndPayBill();
                        break;
                    case 6:
                        PatientConsole.searchPatient();
                        break;
                    case 7:
                        DoctorConsole.listDoctors();
                        break;
                    case 8:
                        CSVConsole.saveDataToCsv();
                        break;
                    case 9:
                        AnalyticsConsole.showStreamsAnalytics();
                        break;
                    case 10:
                        System.out.println("Returning to Main Menu...");
                        return;
                    default:
                        System.out.println("Invalid option");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

    }
}
