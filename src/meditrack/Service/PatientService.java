package meditrack.Service;

import meditrack.Entity.Patient;
import meditrack.Repositories.PatientRepository;
import meditrack.Exception.EntityNotFoundException;
import meditrack.util.Validator;

import java.time.LocalDate;
import java.util.List;
import meditrack.Exception.InvalidInputException;

public class PatientService {

    public static String createNewPatient(String name,
                                        String email,
                                        String phone,
                                        LocalDate dob) throws InvalidInputException {

        if (!Validator.isValidEmail(email)) {
            throw new InvalidInputException("Email is invalid!");
        }
        if (!Validator.isValidNumber(phone)) {
            throw new InvalidInputException("Invalid Phone Number");
        }
        if (dob == null || dob.isAfter(LocalDate.now())) {
            throw new InvalidInputException("Invalid DOB");
        }

        String id = PatientRepository.addPatient(name, email, phone, dob);
        System.out.println("Patient created successfully. ID: " + id);
        return id;
    }

    // overloaded - by id
    public static Patient searchPatient(String patientId) throws EntityNotFoundException {
        Patient patient = PatientRepository.findById(patientId);
        if (patient == null) {
            throw new EntityNotFoundException("Invalid Patient ID!");
        }
        return patient;
    }

    // overloaded - by name
    public static List<Patient> searchPatient(String name, boolean byName) {
        if (!byName) {
            return List.of();
        }
        return PatientRepository.findByName(name);
    }

    public static List<Patient> searchPatient(int age) {
        return PatientRepository.findByAge(age);
    }

    public static boolean deletePatient(String patientId) {
        return PatientRepository.removeById(patientId);
    }

    public static List<Patient> getAllPatients() {
        return PatientRepository.getAll();
    }
}
