package meditrack.Entity;

public class Doctor extends Person implements Cloneable {

    private Speciality speciality;
    private double consultationFee;

    public Doctor(String personId,
                  String name,
                  String email,
                  String phoneNumber,
                  Speciality speciality,
                  double consultationFee) {

        super(personId, name, email, phoneNumber);
        this.speciality = speciality;
        this.consultationFee = consultationFee;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    @Override
    public Doctor clone() {
        return new Doctor(getPersonId(), getName(), getEmail(), getPhoneNumber(), speciality, consultationFee);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id='" + getPersonId() + '\'' +
                ", name='" + getName() + '\'' +
                ", speciality=" + speciality +
                ", fee=" + consultationFee +
                '}';
    }
}
