package meditrack.Service;

import meditrack.Entity.Doctor;
import meditrack.Entity.Speciality;
import meditrack.Exception.EntityNotFoundException;
import meditrack.Exception.InvalidInputException;
import meditrack.Repositories.DoctorRepository;
import meditrack.util.Validator;

import java.util.List;

public class DoctorService {

    public static String addNewDoctor(String name,
                                      String email,
                                      String phone,
                                      Speciality speciality,
                                      double fee) {

        if (!Validator.isValidEmail(email)) {
            throw new InvalidInputException("Invalid email");
        }
        if (!Validator.isValidNumber(phone)) {
            throw new InvalidInputException("Invalid phone");
        }
        if (fee <= 0) {
            throw new InvalidInputException("Invalid fee");
        }

        return DoctorRepository.addDoctor(name, email, phone, speciality, fee);
    }

    public static Doctor searchDoctorById(String doctorId) throws EntityNotFoundException {
        Doctor doctor = DoctorRepository.findById(doctorId);
        if (doctor == null) {
            throw new EntityNotFoundException("Invalid Doctor ID!");
        }
        return doctor;
    }

    public static List<Doctor> searchDoctorByName(String name) {
        return DoctorRepository.findByName(name);
    }

    public static boolean deleteDoctor(String id) {
        return DoctorRepository.removeById(id);
    }

    public static List<Doctor> getAllDoctors() {
        return DoctorRepository.getAll();
    }
}
