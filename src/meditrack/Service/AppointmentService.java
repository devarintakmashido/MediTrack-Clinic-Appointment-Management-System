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

public class AppointmentService {

    public static void bookAppointment(String patient_id, String doctor_id, LocalDate dateOfAppointment) throws EntityNotFoundException {
        Patient patient = PatientRepository.findById(patient_id);
        if (patient == null){
            throw new EntityNotFoundException("Invalid Patient ID!");
        }
        Doctor doctor = DoctorRepository.findById(doctor_id);
        if(doctor == null){
            throw new EntityNotFoundException("Invalid Doctor ID!");
        }

        if(Validator.isValidDate(dateOfAppointment)){
            throw new EntityNotFoundException("Invalid Appointment Date");
        }

        String appointment_id = AppointmentRepository.addAppointment(doctor,patient,dateOfAppointment);
        System.out.println("Appointment is Booked \n appointmentId :"+appointment_id);
    }

    public static void cancelAppointment(String appointment_id) throws EntityNotFoundException {
        Appointment appointment = AppointmentRepository.findById(appointment_id);

        if (appointment == null){
            throw new EntityNotFoundException("Invalid Appointment ID!");
        }


        System.out.println(AppointmentRepository.cancelAppointment(appointment_id));
    }

    public static void upcomingAppointmentsForPatient(String patient_id) throws EntityNotFoundException {
        Patient patient = PatientRepository.findById(patient_id);
        if (patient == null){
            throw new EntityNotFoundException("Invalid Patient ID!");
        }

//        repo function is yet to be written
    }

    public static void upcomingAppointmentsForDoctor(String doctor_id){

    }


}
