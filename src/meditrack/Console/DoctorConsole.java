package meditrack.Console;

import meditrack.Entity.Doctor;
import meditrack.Entity.Speciality;
import meditrack.Service.DoctorService;

import java.util.List;
import java.util.Scanner;

public class DoctorConsole {
    static Scanner sc = new Scanner(System.in);

    public static void addDoctor() {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();
        System.out.print("Speciality (CARDIOLOGY/DENTISTRY/ORTHOPEDICS/GENERAL/NEUROLOGY/PEDIATRICS): ");
        Speciality speciality = Speciality.valueOf(sc.nextLine().trim().toUpperCase());
        System.out.print("Fee: ");
        double fee = Double.parseDouble(sc.nextLine());


        String id = DoctorService.addNewDoctor(name, email, phone, speciality, fee);
        System.out.println("Doctor added: " + id);
    }

    public static void listDoctors() {
        List<Doctor> doctors = DoctorService.getAllDoctors();
        for (Doctor d : doctors) {
            System.out.println(d);
        }
    }
}
