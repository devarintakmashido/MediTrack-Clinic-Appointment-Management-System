package meditrack.Entity;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Patient extends Person implements Cloneable {

    private LocalDate dob;
    private List<String> medicalHistory;

    public Patient(String personId,
                   String name,
                   String email,
                   String phoneNumber,
                   LocalDate dob) {

        super(personId, name, email, phoneNumber);
        this.dob = dob;
        this.medicalHistory = new ArrayList<>();
    }

    public int getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public List<String> getMedicalHistory() {
        return new ArrayList<>(medicalHistory);
    }

    public void addMedicalRecord(String record) {
        this.medicalHistory.add(record);
    }

    public void setMedicalHistory(List<String> medicalHistory) {
        this.medicalHistory = new ArrayList<>(medicalHistory);
    }

    @Override
    public Patient clone() {
        Patient copy = new Patient(getPersonId(), getName(), getEmail(), getPhoneNumber(), dob);
        copy.setMedicalHistory(this.medicalHistory);
        return copy;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id='" + getPersonId() + '\'' +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                '}';
    }
}
