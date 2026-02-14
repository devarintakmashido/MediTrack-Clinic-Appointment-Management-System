package meditrack.Service;

import meditrack.Entity.Appointment;
import meditrack.Entity.Bill;
import meditrack.Entity.BillSummary;
import meditrack.Repositories.AppointmentRepository;
import meditrack.Repositories.BillRepository;
import meditrack.Repositories.BillSummaryRepo;
import meditrack.Exception.EntityNotFoundException;

public class BillService {

    public static String generateBill(String appointment_id) throws EntityNotFoundException {
        Appointment appointment = AppointmentRepository.findById(appointment_id);
        if (appointment == null) {
            throw new EntityNotFoundException("Invalid appointment id");
        }
        String billId = BillRepository.addBill(appointment);
        System.out.println("Bill generated: " + billId);
        return billId;
    }

    public static BillSummary payBill(String bill_id) throws EntityNotFoundException {
        Bill bill = BillRepository.getById(bill_id);
        if (bill == null) {
            throw new EntityNotFoundException("Invalid Bill Id");
        }
        BillSummary billSummary = bill.generateBillSummary();
        BillSummaryRepo.addSummary(billSummary);
        return billSummary;
    }
}
