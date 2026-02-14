package Entity;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {

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
        return  Period.between(dob, LocalDate.now()).getYears();
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public List<String> getMedicalHistory() {
        return medicalHistory;
    }

    public void addMedicalRecord(String record) {
        this.medicalHistory.add(record);
    }

    public void setMedicalHistory(List<String> medicalHistory) {
        this.medicalHistory = medicalHistory;
    }


}