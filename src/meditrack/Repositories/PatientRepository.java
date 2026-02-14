package meditrack.Repositories;

import meditrack.Entity.Patient;
import meditrack.util.DataStore;
import meditrack.util.IdGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PatientRepository {
    private final static DataStore<Patient> patientDataStore = new DataStore<>();

    public static String addPatient(String name,
                                    String email,
                                    String phoneNumber,
                                    LocalDate dob) {
        String person_id = IdGenerator.generateID("PATIENT");
        Patient patient = new Patient(person_id, name, email, phoneNumber, dob);
        patientDataStore.add(patient);
        return person_id;
    }

    public static List<Patient> getAll() {
        return patientDataStore.getAll();
    }

    public static Patient findById(String id) {
        for (Patient d : patientDataStore.getAll()) {
            if (d.getPersonId().equals(id)) {
                return d;
            }
        }
        return null;
    }

    public static boolean removeById(String id) {
        Patient patient = findById(id);
        if (patient == null) {
            return false;
        }
        patientDataStore.remove(patient);
        return true;
    }

    public static List<Patient> findByName(String name) {
        List<Patient> result = new ArrayList<>();
        for (Patient p : patientDataStore.getAll()) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }

    public static List<Patient> findByAge(int age) {
        List<Patient> result = new ArrayList<>();
        for (Patient p : patientDataStore.getAll()) {
            if (p.getAge() == age) {
                result.add(p);
            }
        }
        return result;
    }
}
