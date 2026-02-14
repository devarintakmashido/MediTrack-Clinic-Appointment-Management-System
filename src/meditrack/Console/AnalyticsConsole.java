package meditrack.Console;

import meditrack.Entity.Doctor;
import meditrack.Entity.Speciality;
import meditrack.Service.AppointmentService;
import meditrack.Service.DoctorService;

import java.util.List;
import java.util.Scanner;

public class AnalyticsConsole {
    static Scanner sc = new Scanner(System.in);

    public static void showStreamsAnalytics() {
        System.out.println("Streams Menu");
        System.out.println("1. Filter doctors by speciality");
        System.out.println("2. Average consultation fee");
        System.out.println("3. Appointments per doctor");
        System.out.print("Choose: ");


        int option = Integer.parseInt(sc.nextLine());
        if (option == 1) {
            System.out.print("Enter speciality: ");
            Speciality speciality = Speciality.valueOf(sc.nextLine().trim().toUpperCase());
            List<Doctor> list = DoctorService.getDoctorsBySpeciality(speciality);
            if (list.isEmpty()) {
                System.out.println("No doctors found.");
            } else {
                list.forEach(System.out::println);
            }
        } else if (option == 2) {
            double avg = DoctorService.getAverageConsultationFee();
            System.out.println("Average consultation fee: " + avg);
        } else if (option == 3) {
            var map = AppointmentService.getAppointmentCountPerDoctor();
            if (map.isEmpty()) {
                System.out.println("No appointments found.");
            } else {
                map.forEach((doctor, count) -> System.out.println(doctor + " -> " + count));
            }
        } else {
            System.out.println("Invalid option");
        }
    }
}
