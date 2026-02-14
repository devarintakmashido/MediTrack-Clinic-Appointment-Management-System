package meditrack.Console;

import meditrack.Entity.Appointment;
import meditrack.Entity.Doctor;
import meditrack.Entity.Patient;
import meditrack.Entity.Speciality;
import meditrack.Service.AppointmentService;
import meditrack.Service.DoctorService;
import meditrack.Service.PatientService;
import meditrack.constants.Constants;
import meditrack.util.CSVUtil;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CSVConsole {
    static Scanner sc = new Scanner(System.in);
    public static void saveDataToCsv() throws IOException {
        for (Doctor doctor : DoctorService.getAllDoctors()) {
            String line = doctor.getPersonId() + "," + doctor.getName() + "," + doctor.getEmail() + "," + doctor.getPhoneNumber() + "," + doctor.getSpeciality() + "," + doctor.getConsultationFee();
            CSVUtil.writeLine(Constants.DOCTOR_CSV, line);
        }


        for (Patient patient : PatientService.getAllPatients()) {
            String line = patient.getPersonId() + "," + patient.getName() + "," + patient.getEmail() + "," + patient.getPhoneNumber() + "," + patient.getDob();
            CSVUtil.writeLine(Constants.PATIENT_CSV, line);
        }


        for (Appointment appointment : AppointmentService.getAllAppointments()) {
            String line = appointment.getAppointmentId() + "," + appointment.getDoctor().getPersonId() + "," + appointment.getPatient().getPersonId() + "," + appointment.getDateOfAppointment() + "," + appointment.getStatus();
            CSVUtil.writeLine(Constants.APPOINTMENT_CSV, line);
        }


        System.out.println("Data saved to CSV.");
    }


    public static void loadDataFromCsv() {
        try {
            List<String[]> doctors = CSVUtil.readAll(Constants.DOCTOR_CSV);
            for (String[] d : doctors) {
                if (d.length >= 6) {
                    DoctorService.addNewDoctor(d[1], d[2], d[3], Speciality.valueOf(d[4]), Double.parseDouble(d[5]));
                }
            }


            List<String[]> patients = CSVUtil.readAll(Constants.PATIENT_CSV);
            for (String[] p : patients) {
                if (p.length >= 5) {
                    PatientService.createNewPatient(p[1], p[2], p[3], LocalDate.parse(p[4]));
                }
            }


            List<String[]> appointments = CSVUtil.readAll(Constants.APPOINTMENT_CSV);
            for (String[] a : appointments) {
                if (a.length >= 4) {
                    AppointmentService.bookAppointment(a[2], a[1], LocalDate.parse(a[3]));
                }
            }


            System.out.println("CSV data loaded.");
        } catch (Exception e) {
            System.out.println("Could not load CSV data: " + e.getMessage());
        }
    }
}
