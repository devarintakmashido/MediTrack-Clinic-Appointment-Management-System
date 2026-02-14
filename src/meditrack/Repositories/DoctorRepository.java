package Repositories;

import Entity.Doctor;
import Entity.Speciality;
import util.DataStore;
import util.IdGenerator;

import java.util.List;

public class DoctorRepository {
    static DataStore<Doctor> doctorDataStore = new DataStore<>();

    public void addDoctor(String name,
                             String email,
                             String phoneNumber,
                             Speciality speciality,
                             double consultationFee){
        String person_id = IdGenerator.generateID("DOC");
        Doctor doctor = new Doctor(person_id,name,email,phoneNumber,speciality,consultationFee);
        doctorDataStore.add(doctor);
//        return true;
    }

    public List<Doctor> getAll(){
        return doctorDataStore.getAll();
    }

    public static Doctor findById(String id){
        for (Doctor d : doctorDataStore.getAll()) {
            if (d.getPersonId().equals(id)) {
                return d;
            }
        }
        return null;
    }
}
