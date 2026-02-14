//package com.airtribe.meditrack.test;
//
//import com.airtribe.meditrack.entity.*;
//import com.airtribe.meditrack.service.*;
//import com.airtribe.meditrack.util.IdGenerator;
//
//import java.time.LocalDate;
//import java.util.Arrays;
//
//public class TestRunner {
//
//    public static void main(String[] args) throws Exception {
//
//        DoctorService ds = new DoctorService();
//        PatientService ps = new PatientService();
//        AppointmentService as = new AppointmentService();
//
//        Doctor d = new Doctor(IdGenerator.generate(), "Dr. Sharma","9999","Cardio",500);
//        ds.addDoctor(d);
//
//        Patient p = new Patient(IdGenerator.generate(), "Amit","8888",30, Arrays.asList("Diabetes"));
//
//        ps.addPatient(p);
//
//        Appointment a = new Appointment(IdGenerator.generate(), d.getId(), p.getId(), LocalDate.now());
//        as.book(a);
//        as.complete(a.getId());
//
//        System.out.println("SYSTEM WORKING SUCCESSFULLY");
//    }
//}
//------------------------------------------------------------------------------------------------

package meditrack.test;


import meditrack.Entity.Appointment;
import meditrack.Entity.Bill;
import meditrack.Entity.Doctor;
import meditrack.Entity.Patient;
import meditrack.Service.AppointmentService;
import meditrack.Service.BillService;
import meditrack.Service.DoctorService;
import meditrack.Service.PatientService;
import meditrack.util.IdGenerator;

import java.time.LocalDate;
import java.util.List;

public class TestRunner {

    public static void main(String[] args) throws Exception {

        DoctorService doctorService = new DoctorService();
        PatientService patientService = new PatientService();
        AppointmentService appointmentService = new AppointmentService();
        BillService billService = new BillService();

        //NEEDS CHANGES HERE
//        // Create Doctor
//        Doctor doctor = new Doctor(IdGenerator.generate(), "Dr. Sharma", "9999999999", "Cardiology", 500);
//        doctorService.addDoctor(doctor);
//
//        // Create Patient
//        Patient patient = new Patient(IdGenerator.generate(), "Amit", "8888888888", 30, List.of("Diabetes"));
//        patientService.addPatient(patient);
//
//        // Book Appointment
//        Appointment appointment = new Appointment(IdGenerator.generate(), doctor.getId(), patient.getId(), LocalDate.now());
//        appointmentService.book(appointment);
//
//        // Complete Appointment
//        appointmentService.completeAppointment(appointment.getId());
//        System.out.println(appointment.getDate());
//
//        // Generate Bill
//        Bill bill = billService.generateBill(appointment, doctor);
//
//        System.out.println("Bill Generated");
//        System.out.println("Amount: " + bill.getAmount());
//        System.out.println("Paid: " + bill.isPaid());
//
//        // Pay Bill
//        bill.payBill();
//
//        System.out.println("Bill Paid: " + bill.isPaid());
//
//        billService.exportBills("bills.csv");
//        appointmentService.exportAppointmentsToCSV("appointments.csv");

    }
}
