package meditrack.Repositories;

import meditrack.Entity.Doctor;
import meditrack.Entity.Speciality;
import meditrack.util.DataStore;
import meditrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class DoctorRepository {
    static DataStore<Doctor> doctorDataStore = new DataStore<>();

    public static String addDoctor(String name,
                                   String email,
                                   String phoneNumber,
                                   Speciality speciality,
                                   double consultationFee) {
        String person_id = IdGenerator.generateID("DOC");
        Doctor doctor = new Doctor(person_id, name, email, phoneNumber, speciality, consultationFee);
        doctorDataStore.add(doctor);
        return person_id;
    }

    public static List<Doctor> getAll() {
        return doctorDataStore.getAll();
    }

    public static Doctor findById(String id) {
        for (Doctor d : doctorDataStore.getAll()) {
            if (d.getPersonId().equals(id)) {
                return d;
            }
        }
        return null;
    }

    public static boolean removeById(String id) {
        Doctor doctor = findById(id);
        if (doctor == null) {
            return false;
        }
        doctorDataStore.remove(doctor);
        return true;
    }

    public static List<Doctor> findByName(String name) {
        List<Doctor> result = new ArrayList<>();
        for (Doctor d : doctorDataStore.getAll()) {
            if (d.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(d);
            }
        }
        return result;
    }
}
