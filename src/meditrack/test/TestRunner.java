package meditrack.test;

import meditrack.Entity.Appointment;
import meditrack.Entity.BillSummary;
import meditrack.Entity.Doctor;
import meditrack.Entity.Patient;
import meditrack.Entity.Speciality;
import meditrack.Service.AppointmentService;
import meditrack.Service.BillService;
import meditrack.Service.DoctorService;
import meditrack.Service.PatientService;

import java.time.LocalDate;

public class TestRunner {

    public static void main(String[] args) throws Exception {
        String doctorId = DoctorService.addNewDoctor("Dr Sharma", "dr@demo.com", "9999999999", Speciality.CARDIOLOGY, 500);
        String patientId = PatientService.createNewPatient("Amit", "amit@demo.com", "8888888888", LocalDate.of(1998, 1, 10));

        String appointmentId = AppointmentService.bookAppointment(patientId, doctorId, LocalDate.now().plusDays(1));
        String billId = BillService.generateBill(appointmentId);
        BillSummary summary = BillService.payBill(billId);

        Appointment originalAppointment = AppointmentService.getAllAppointments().get(0);
        Appointment clonedAppointment = originalAppointment.clone();

        Patient originalPatient = PatientService.searchPatient(patientId);
        Patient clonedPatient = originalPatient.clone();
        clonedPatient.addMedicalRecord("cloned-record");

        Doctor doctor = DoctorService.searchDoctorById(doctorId);

        System.out.println("Doctor: " + doctor);
        System.out.println("Original Patient History: " + originalPatient.getMedicalHistory());
        System.out.println("Cloned Patient History: " + clonedPatient.getMedicalHistory());
        System.out.println("Original Appointment: " + originalAppointment);
        System.out.println("Cloned Appointment: " + clonedAppointment);
        System.out.println("Bill Summary: " + summary);
    }
}
