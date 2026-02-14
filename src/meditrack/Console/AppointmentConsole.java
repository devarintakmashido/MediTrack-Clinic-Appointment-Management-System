package meditrack.Console;

import meditrack.Exception.EntityNotFoundException;
import meditrack.Service.AppointmentService;

import java.time.LocalDate;
import java.util.Scanner;

public class AppointmentConsole {
    static Scanner sc = new Scanner(System.in);

    public static void bookAppointment() throws EntityNotFoundException {
        System.out.print("Patient ID: ");
        String patientId = sc.nextLine();
        System.out.print("Doctor ID: ");
        String doctorId = sc.nextLine();
        System.out.print("Date (yyyy-mm-dd): ");
        LocalDate date = LocalDate.parse(sc.nextLine());


        AppointmentService.bookAppointment(patientId, doctorId, date);
    }


    public static void cancelAppointment() throws EntityNotFoundException {
        System.out.print("Appointment ID: ");
        String appointmentId = sc.nextLine();
        AppointmentService.cancelAppointment(appointmentId);
    }
}
