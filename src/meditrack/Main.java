package meditrack;

import meditrack.Entity.Appointment;
import meditrack.Entity.BillSummary;
import meditrack.Entity.Doctor;
import meditrack.Entity.Patient;
import meditrack.Entity.Speciality;
import meditrack.Exception.EntityNotFoundException;
import meditrack.Exception.InvalidInputException;
import meditrack.Service.AppointmentService;
import meditrack.Service.BillService;
import meditrack.Service.DoctorService;
import meditrack.Service.PatientService;
import meditrack.constants.Constants;
import meditrack.util.CSVUtil;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        if (args.length > 0 && "--loadData".equalsIgnoreCase(args[0])) {
            loadDataFromCsv();
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== MediTrack =====");
            System.out.println("1. Add Doctor");
            System.out.println("2. Add Patient");
            System.out.println("3. Book Appointment");
            System.out.println("4. Cancel Appointment");
            System.out.println("5. Generate + Pay Bill");
            System.out.println("6. Search Patient (id/name/age)");
            System.out.println("7. List Doctors");
            System.out.println("8. Save Data to CSV");
            System.out.println("9. Exit");
            System.out.print("Choose: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception ex) {
                System.out.println("Invalid choice");
                continue;
            }

            try {
                if (choice == 1) {
                    addDoctor(scanner);
                } else if (choice == 2) {
                    addPatient(scanner);
                } else if (choice == 3) {
                    bookAppointment(scanner);
                } else if (choice == 4) {
                    cancelAppointment(scanner);
                } else if (choice == 5) {
                    generateAndPayBill(scanner);
                } else if (choice == 6) {
                    searchPatient(scanner);
                } else if (choice == 7) {
                    listDoctors();
                } else if (choice == 8) {
                    saveDataToCsv();
                } else if (choice == 9) {
                    break;
                } else {
                    System.out.println("Invalid option");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void addDoctor(Scanner scanner) {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Speciality (CARDIOLOGY/DENTISTRY/ORTHOPEDICS/GENERAL/NEUROLOGY/PEDIATRICS): ");
        Speciality speciality = Speciality.valueOf(scanner.nextLine().trim().toUpperCase());
        System.out.print("Fee: ");
        double fee = Double.parseDouble(scanner.nextLine());

        String id = DoctorService.addNewDoctor(name, email, phone, speciality, fee);
        System.out.println("Doctor added: " + id);
    }

    private static void addPatient(Scanner scanner) throws InvalidInputException {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        System.out.print("DOB (yyyy-mm-dd): ");
        LocalDate dob = LocalDate.parse(scanner.nextLine());

        String id = PatientService.createNewPatient(name, email, phone, dob);
        System.out.println("Patient added: " + id);
    }

    private static void bookAppointment(Scanner scanner) throws EntityNotFoundException {
        System.out.print("Patient ID: ");
        String patientId = scanner.nextLine();
        System.out.print("Doctor ID: ");
        String doctorId = scanner.nextLine();
        System.out.print("Date (yyyy-mm-dd): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        AppointmentService.bookAppointment(patientId, doctorId, date);
    }

    private static void cancelAppointment(Scanner scanner) throws EntityNotFoundException {
        System.out.print("Appointment ID: ");
        String appointmentId = scanner.nextLine();
        AppointmentService.cancelAppointment(appointmentId);
    }

    private static void generateAndPayBill(Scanner scanner) throws EntityNotFoundException {
        System.out.print("Appointment ID: ");
        String appointmentId = scanner.nextLine();

        String billId = BillService.generateBill(appointmentId);
        BillSummary summary = BillService.payBill(billId);
        System.out.println("Paid: " + summary);
    }

    private static void searchPatient(Scanner scanner) throws EntityNotFoundException {
        System.out.println("Search by 1-id 2-name 3-age");
        int searchType = Integer.parseInt(scanner.nextLine());

        if (searchType == 1) {
            System.out.print("Patient ID: ");
            Patient p = PatientService.searchPatient(scanner.nextLine());
            System.out.println(p);
        } else if (searchType == 2) {
            System.out.print("Patient name: ");
            List<Patient> list = PatientService.searchPatient(scanner.nextLine(), true);
            for (Patient p : list) {
                System.out.println(p);
            }
        } else if (searchType == 3) {
            System.out.print("Age: ");
            int age = Integer.parseInt(scanner.nextLine());
            List<Patient> list = PatientService.searchPatient(age);
            for (Patient p : list) {
                System.out.println(p);
            }
        }
    }

    private static void listDoctors() {
        List<Doctor> doctors = DoctorService.getAllDoctors();
        for (Doctor d : doctors) {
            System.out.println(d);
        }
    }

    private static void saveDataToCsv() throws IOException {
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

    private static void loadDataFromCsv() {
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
