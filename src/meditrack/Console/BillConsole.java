package meditrack.Console;

import meditrack.Entity.BillSummary;
import meditrack.Exception.EntityNotFoundException;
import meditrack.Service.BillService;

import java.util.Scanner;

public class BillConsole {
    static Scanner sc = new Scanner(System.in);

    public static void generateAndPayBill() throws EntityNotFoundException {
        System.out.print("Appointment ID: ");
        String appointmentId = sc.nextLine();


        String billId = BillService.generateBill(appointmentId);
        BillSummary summary = BillService.payBill(billId);
        System.out.println("Paid: " + summary);
    }
}
