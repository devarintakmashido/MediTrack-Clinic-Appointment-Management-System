package meditrack;


import meditrack.Console.*;

import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        if (args.length > 0 && "--loadData".equalsIgnoreCase(args[0])) {
            CSVConsole.loadDataFromCsv();
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== MediTrack =====");
            System.out.println("1. Add Doctor");
            System.out.println("2. Add Patient");
            System.out.println("3. Book Appointment");
            System.out.println("4. Cancel Appointment");
            System.out.println("5. Generate + Pay Bill");
            System.out.println("6. Search Patient (id/name/age)");
            System.out.println("7. List Doctors");
            System.out.println("8. Save Data to CSV");
            System.out.println("9. Streams Analytics");
            System.out.println("10. Exit");
            System.out.print("Choose: ");


            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception ex) {
                System.out.println("Invalid choice");
                continue;
            }


            try {
                if (choice == 1) {
                    DoctorConsole.addDoctor();
                } else if (choice == 2) {
                    PatientConsole.addPatient();
                } else if (choice == 3) {
                    AppointmentConsole.bookAppointment();
                } else if (choice == 4) {
                    AppointmentConsole.cancelAppointment();
                } else if (choice == 5) {
                    BillConsole.generateAndPayBill();
                } else if (choice == 6) {
                    PatientConsole.searchPatient();
                } else if (choice == 7) {
                    DoctorConsole.listDoctors();
                } else if (choice == 8) {
                    CSVConsole.saveDataToCsv();
                } else if (choice == 9) {
                    AnalyticsConsole.showStreamsAnalytics();
                } else if (choice == 10) {
                    break;
                } else {
                    System.out.println("Invalid option");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

}

