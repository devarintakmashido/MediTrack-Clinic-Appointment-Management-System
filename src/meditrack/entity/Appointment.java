package meditrack.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Appointment implements Serializable {

    private String id;
    private String doctorId;
    private String patientId;
    private LocalDate date;
    private AppointmentStatus status;

    public Appointment(String id, String doctorId, String patientId, LocalDate date) {
        this.id = id;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.date = date;
        this.status = AppointmentStatus.SCHEDULED;
    }

    public String getId() {
        return id;
    }
    public String getDoctorId() {
        return doctorId;
    }
    public String getPatientId() {
        return patientId;
    }
    public LocalDate getDate() {
        return date;
    }
    public AppointmentStatus getStatus() {
        return status;
    }
    public void cancel() {
        this.status = AppointmentStatus.CANCELLED;
    }

    public void markCompleted() {
        this.status = AppointmentStatus.COMPLETED;
    }

}
