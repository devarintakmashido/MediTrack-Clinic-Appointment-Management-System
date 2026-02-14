package meditrack.Console;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import meditrack.Exception.InvalidInputException;
import meditrack.Exception.EntityNotFoundException;
import meditrack.Entity.Patient;
import meditrack.Service.PatientService;

public class PatientConsole {
    static Scanner sc = new Scanner(System.in);

    public static void addPatient() throws InvalidInputException {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();
        System.out.print("DOB (yyyy-mm-dd): ");
        LocalDate dob = LocalDate.parse(sc.nextLine());


        String id = PatientService.createNewPatient(name, email, phone, dob);
        System.out.println("Patient added: " + id);
    }

    public static void searchPatient() throws EntityNotFoundException {
        System.out.println("Search by 1-id 2-name 3-age");
        int searchType = Integer.parseInt(sc.nextLine());


        if (searchType == 1) {
            System.out.print("Patient ID: ");
            Patient p = PatientService.searchPatient(sc.nextLine());
            System.out.println(p);
        } else if (searchType == 2) {
            System.out.print("Patient name: ");
            List<Patient> list = PatientService.searchPatient(sc.nextLine(), true);
            for (Patient p : list) {
                System.out.println(p);
            }
        } else if (searchType == 3) {
            System.out.print("Age: ");
            int age = Integer.parseInt(sc.nextLine());
            List<Patient> list = PatientService.searchPatient(age);
            for (Patient p : list) {
                System.out.println(p);
            }
        }
    }

}