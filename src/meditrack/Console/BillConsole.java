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

    public static void generateBill() throws EntityNotFoundException{
        System.out.print("Appointment ID: ");
        String appointmentId = sc.nextLine();

        String billId = BillService.generateBill(appointmentId);
        System.out.println("BillId : " + billId);
    }

    public static void payBill() throws EntityNotFoundException{
        System.out.println("BillId : " );
        String billId = sc.nextLine();
        BillSummary summary = BillService.payBill(billId);
        System.out.println("Paid: " + summary);
    }
}
