package Repositories;

import Entity.Patient;
import util.DataStore;
import util.IdGenerator;

import java.time.LocalDate;
import java.util.List;

public class PatientRepository {
    private final static DataStore<Patient> patientDataStore = new DataStore<>();

    public static void addPatient(String name,
                                  String email,
                                  String phoneNumber,
                                  LocalDate dob){
        String person_id = IdGenerator.generateID("PATIENT");
        Patient patient = new Patient(person_id,name,email,phoneNumber,dob);
        patientDataStore.add(patient);
    }

    public static List<Patient> getAll(){
        return patientDataStore.getAll();
    }

    public static Patient findById(String id){
        for (Patient d : patientDataStore.getAll()) {
            if (d.getPersonId().equals(id)) {
                return d;
            }
        }
        return null;
    }

//    public boolean updateName(String id,String name){
//
//    }
}
