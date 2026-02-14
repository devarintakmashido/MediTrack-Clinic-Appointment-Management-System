package Service;

import Entity.Appointment;
import Entity.Bill;
import Entity.BillSummary;
import Repositories.AppointmentRepository;
import Repositories.BillRepository;
import Repositories.BillSummaryRepo;
import Exception.EntityNotFoundException;

public class BillService {

    public static void generateBill(String appointment_id) throws EntityNotFoundException {
        Appointment appointment = AppointmentRepository.findById(appointment_id);
        if(appointment == null){
            throw new EntityNotFoundException("Invalid appointment id");
        }
        BillRepository.addBill(appointment);

    }

    public static void payBill(String bill_id) throws EntityNotFoundException {
        Bill bill = BillRepository.getById(bill_id);
        if(bill == null){
            throw new EntityNotFoundException("Invalid Bill Id");
        }
        BillSummary billSummary = bill.generateBillSummary();
        BillSummaryRepo.addSummary(billSummary);

    }
}
