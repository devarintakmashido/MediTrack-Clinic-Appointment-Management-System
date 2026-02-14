package meditrack.Repositories;

import meditrack.Entity.Appointment;
import meditrack.Entity.AppointmentStatus;
import meditrack.Entity.Doctor;
import meditrack.Entity.Patient;
import meditrack.util.DataStore;
import meditrack.util.IdGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AppointmentRepository {
    private static final DataStore<Appointment> appointmentDataStore = new DataStore<>();

    public static Appointment findById(String id) {
        for (Appointment appointment : appointmentDataStore.getAll()) {
            if (appointment.getAppointmentId().equals(id)) {
                return appointment;
            }
        }
        return null;
    }

    public static List<Appointment> getAll() {
        return appointmentDataStore.getAll();
    }

    public static String addAppointment(Doctor doctor, Patient patient, LocalDate dateOfAppointment) {
        String appointment_id = IdGenerator.generateID("APPOINTMENT");
        Appointment appointment = new Appointment(appointment_id, doctor, patient, dateOfAppointment);
        appointment.confirm();
        appointmentDataStore.add(appointment);
        return appointment_id;
    }

    public static String cancelAppointment(String appointment_id) {
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

    public static List<Appointment> getByPatientId(String patientId) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment a : appointmentDataStore.getAll()) {
            if (a.getPatient().getPersonId().equals(patientId)) {
                result.add(a);
            }
        }
        return result;
    }

    public static List<Appointment> getByDoctorId(String doctorId) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment a : appointmentDataStore.getAll()) {
            if (a.getDoctor().getPersonId().equals(doctorId)) {
                result.add(a);
            }
        }
        return result;
    }
}
