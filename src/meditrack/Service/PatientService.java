package Service;

import Entity.Patient;
import Repositories.PatientRepository;
import Exception.EntityNotFoundException;
import util.Validator;

import java.time.LocalDate;
import Exception.InvalidInputException;

public class PatientService {

    public static void createNewPatient(String name,
                                        String email,
                                        String phone,
                                        LocalDate dob) throws InvalidInputException {

        if (!Validator.isValidEmail(email)){
            throw new InvalidInputException("Email is invalid!");
        }
        if (Validator.isValidNumber(phone)){
            throw new InvalidInputException("Invalid Phone Number");
        }
//        if (Validator.isValidDob)
        PatientRepository.addPatient(name, email, phone, dob);

        System.out.println("Patient created successfully.");
    }

    public static void searchPatientById(String patient_id) throws EntityNotFoundException {
        Patient patient = PatientRepository.findById(patient_id);
        if (patient == null){
            throw new EntityNotFoundException("Invalid Patient ID!");
        }

        patient.toString();
    }






}
