package meditrack.Repositories;

import meditrack.Entity.Appointment;
import meditrack.Entity.Bill;
import meditrack.Entity.Patient;
import meditrack.util.DataStore;
import meditrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class BillRepository {
    static final DataStore<Bill> billDataStore = new DataStore<>();

    public static void addBill(Appointment appointment){
        String bill_id = IdGenerator.generateID("BILL");
        Bill bill = new Bill(bill_id,appointment);
    }

    public static Bill getById(String billId) {
        for (Bill bill : billDataStore.getAll()) {
            if (bill.getBillId().equals(billId)) {
                return bill;
            }
        }
        return null;
    }

    public Bill getByAppointmentId(String appointmentId) {
        for (Bill bill : billDataStore.getAll()) {
            if (bill.getAppointment().getAppointmentId().equals(appointmentId)) {
                return bill;
            }
        }

        return null;
    }

    public List<Bill> getByPatientId(String patientId) {

        List<Bill> billsOfPatient = new ArrayList<>();

        for (Bill bill : billDataStore.getAll()) {

            Appointment appointment = bill.getAppointment();
            Patient patient = appointment.getPatient();

            if (patient.getPersonId().equals(patientId)) {
                billsOfPatient.add(bill);
            }
        }

        return billsOfPatient;
    }

    public List<Bill> getAllBills() {
        return billDataStore.getAll();
    }

}
