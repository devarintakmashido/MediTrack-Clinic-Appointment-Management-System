package meditrack.service;

import com.airtribe.meditrack.entity.*;
import com.airtribe.meditrack.util.CSVUtil;
import com.airtribe.meditrack.util.DataStore;

public class BillingService {

    private final DataStore<Bill> billStore = new DataStore<>();

    // Generate bill after appointment completion
    public Bill generateBill(Appointment appointment, Doctor doctor) {

        if (appointment.getStatus() != AppointmentStatus.COMPLETED) {
            throw new IllegalStateException("Bill can only be generated for COMPLETED appointments");
        }

        Bill bill = new Bill(appointment.getId(), doctor.getConsultationFee());
        billStore.save(appointment.getId(), bill);
        return bill;
    }

    public Bill getBillByAppointmentId(String appointmentId) {
        return billStore.findById(appointmentId);
    }

    public void exportBills(String file) throws Exception {

        CSVUtil.writeLine(file, "AppointmentId,Amount,Paid");

        for (Bill bill : billStore.findAll()) {
            CSVUtil.writeLine(file,
                    bill.getAppointmentId() + "," +
                            bill.getAmount() + "," +
                            bill.isPaid());
        }
    }
}
