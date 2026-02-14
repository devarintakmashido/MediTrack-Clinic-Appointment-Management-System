package meditrack.Menu;

import meditrack.Console.*;

import java.util.Scanner;

public class Menu {
    static Scanner sc = new Scanner(System.in);
    public static void mainMenu(){
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("----------------Welcome to MediTrack — Clinic & Appointment Management System--------------------");
        System.out.println("1. Patient Menu");
        System.out.println("2. Doctor Menu");
        System.out.println("3. Admin Menu");
        System.out.println("4. Exit");
    }

    public static void doctorMenu(){
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("----------------Welcome to MediTrack — Clinic & Appointment Management System--------------------");
        System.out.println("1. search Patient (id/name/age)");
        System.out.println("2. Cancel Appointment");
        System.out.println("3. Exit");
    }

    public static void patientMenu(){
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("----------------Welcome to MediTrack — Clinic & Appointment Management System--------------------");
        System.out.println("1. Book Appointment");
        System.out.println("2. Cancel Appointment");
        System.out.println("3. List Doctors");
        System.out.println("4. Generate + Pay Bill");
        System.out.println("5. Exit");
    }

    public static void adminMenu(){
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("----------------Welcome to MediTrack — Clinic & Appointment Management System--------------------");
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

//-------------------------------------------------------------------------------------------------------------
        System.out.print("Choose: ");


    }
}
