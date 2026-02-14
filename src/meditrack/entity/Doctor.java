package meditrack.entity;

import java.io.Serializable;

public class Doctor extends Person implements Serializable {

    private String specialization;
    private double consultationFee;

    public Doctor(String id, String name, String phone, String specialization, double consultationFee) {
        super(id, name, phone);
        this.specialization = specialization;
        this.consultationFee = consultationFee;
    }

    public String getSpecialization() {
        return specialization;
    }

    public double getConsultationFee() {
        return consultationFee;
    }
}
