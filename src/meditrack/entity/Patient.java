package meditrack.entity;

import java.io.Serializable;
import java.util.List;

public class Patient extends Person implements Serializable {

    private int age;
    private List<String> medicalHistory;

    public Patient(String id, String name, String phone, int age, List<String> medicalHistory) {
        super(id, name, phone);
        this.age = age;
        this.medicalHistory = medicalHistory;
    }

    public int getAge() {
        return age;
    }

    public List<String> getMedicalHistory() {
        return medicalHistory;
    }
}
