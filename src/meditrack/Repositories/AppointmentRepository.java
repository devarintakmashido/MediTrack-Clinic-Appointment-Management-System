package meditrack.Repositories;

import meditrack.Entity.Appointment;
import meditrack.Entity.AppointmentStatus;
import meditrack.Entity.Doctor;
import meditrack.Entity.Patient;
import util.DataStore;
import util.IdGenerator;

import java.time.LocalDate;

public class AppointmentRepository {
    private static final DataStore<Appointment> appointmentDataStore = new DataStore<>();
    public static Appointment findById(String id){
        for (Appointment appointment : appointmentDataStore.getAll()) {
            if (appointment.getAppointmentId().equals(id)) {
                return appointment;//.displayAppointment();
            }
        }
        return null;
    }

    public static String addAppointment(Doctor doctor, Patient patient, LocalDate dateOfAppointment){
        String appointment_id = IdGenerator.generateID("APPOINTMENT");
        Appointment appointment = new Appointment(appointment_id,doctor,patient,dateOfAppointment);
        appointmentDataStore.add(appointment);
        return appointment_id;
    }

    public static String cancelAppointment(String appointment_id){
        for (Appointment appointment : appointmentDataStore.getAll()) {
            if (appointment.getAppointmentId().equals(appointment_id)) {

                if (appointment.getStatus() == AppointmentStatus.CANCELLED) {
                    return "Appointment already cancelled.";
                }

                appointment.cancel();
                return "Appointment cancelled successfully.";
            }
        }

        return "Invalid appointment ID.";
    }
}
