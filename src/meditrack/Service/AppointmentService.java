package meditrack.Service;


import meditrack.Entity.Appointment;
import meditrack.Entity.Doctor;
import meditrack.Entity.Patient;
import meditrack.Repositories.AppointmentRepository;
import meditrack.Repositories.DoctorRepository;
import meditrack.Repositories.PatientRepository;
import meditrack.util.Validator;
import meditrack.Exception.EntityNotFoundException;


import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes

public class AppointmentService {


    public static String bookAppointment(String patient_id, String doctor_id, LocalDate dateOfAppointment) throws EntityNotFoundException {
        Patient patient = PatientRepository.findById(patient_id);
        if (patient == null) {
            throw new EntityNotFoundException("Invalid Patient ID!");
        }
        Doctor doctor = DoctorRepository.findById(doctor_id);
        if (doctor == null) {
            throw new EntityNotFoundException("Invalid Doctor ID!");
        }


        if (!Validator.isValidDate(dateOfAppointment)) {
            throw new EntityNotFoundException("Invalid Appointment Date");
        }


        String appointment_id = AppointmentRepository.addAppointment(doctor, patient, dateOfAppointment);
        System.out.println("Appointment is Booked. appointmentId: " + appointment_id);
        return appointment_id;
    }


    public static void cancelAppointment(String appointment_id) throws EntityNotFoundException {
        Appointment appointment = AppointmentRepository.findById(appointment_id);


        if (appointment == null) {
            throw new EntityNotFoundException("Invalid Appointment ID!");
        }


        System.out.println(AppointmentRepository.cancelAppointment(appointment_id));
    }


    public static List<Appointment> upcomingAppointmentsForPatient(String patient_id) throws EntityNotFoundException {
        Patient patient = PatientRepository.findById(patient_id);
        if (patient == null) {
            throw new EntityNotFoundException("Invalid Patient ID!");
        }


        return AppointmentRepository.getByPatientId(patient_id);
    }


    public static List<Appointment> upcomingAppointmentsForDoctor(String doctor_id) throws EntityNotFoundException {
        Doctor doctor = DoctorRepository.findById(doctor_id);
        if (doctor == null) {
            throw new EntityNotFoundException("Invalid Doctor ID!");
        }
        return AppointmentRepository.getByDoctorId(doctor_id);
    }


    public static List<Appointment> getAllAppointments() {
        return AppointmentRepository.getAll();
    }

<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
    public static Map<String, Long> getAppointmentCountPerDoctor() {
        return AppointmentRepository.getAll()
                .stream()
                .collect(Collectors.groupingBy(
                        a -> a.getDoctor().getPersonId() + " - " + a.getDoctor().getName(),
                        Collectors.counting()
                ));
    }
}
