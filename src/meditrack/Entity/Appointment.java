package meditrack.Entity;

import java.time.LocalDate;

public class Appointment {
    private final String appointmentId;
    private Patient patient;
    private Doctor doctor;
    private AppointmentStatus appointmentStatus;
    private LocalDate dateOfAppointment;



    public Appointment(String appointmentId, Doctor doctor, Patient patient, LocalDate dateOfAppointment) {
        this.appointmentId = appointmentId;
        this.doctor = doctor;
        this.patient = patient;
        this.dateOfAppointment = dateOfAppointment;
        this.appointmentStatus = AppointmentStatus.SCHEDULED;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public Doctor getDoctor() {
        return doctor;
    }


//    public AppointmentStatus getStatus{
//        return appointmentStatus;
//    }

    public void cancel() {
        this.appointmentStatus = AppointmentStatus.CANCELLED;
    }

    public void markCompleted() {
        this.appointmentStatus = AppointmentStatus.COMPLETED;
    }

    public AppointmentStatus getStatus() {
        return appointmentStatus;
    }
    public void displayAppointment(){
        System.out.println("Appointment Id:" + appointmentId);
        System.out.println("Doctor Name/Doctor ID" + doctor.getName() + "/" + doctor.getPersonId());
        System.out.println("Patient Name/Patient ID" + patient.getName() + "/" + patient.getPersonId());
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId='" + appointmentId + '\'' +
                ", doctor=" + doctor.getName() +
                " (" + doctor.getPersonId() + ")" +
                ", patient=" + patient.getName() +
                " (" + patient.getPersonId() + ")" +
                ", date=" + dateOfAppointment +
                ", status=" + appointmentStatus +
                '}';
    }

    public double getDoctorFee() {
        return doctor.getConsultationFee();
    }

    public Patient getPatient() {
        return patient;
    }
}
