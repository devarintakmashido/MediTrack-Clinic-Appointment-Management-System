# 🏥 MediTrack — Clinic & Appointment Management System

MediTrack is a layered, console-based Clinic & Appointment Management System built entirely from scratch using Core Java.

The application demonstrates strong OOP principles, clean architecture, design patterns, Java 8 streams, file I/O, concurrency basics, and structured package organization.

---

# 🚀 Features

## 👤 Patient Management
- Add patient  
- Search patient (by ID / name / age)  
- Add medical history  
- View patient details  

## 👨‍⚕️ Doctor Management
- Add doctor  
- List doctors  
- Filter by specialization (Streams)  
- Compute average consultation fee  

## 📅 Appointment Management
- Book appointment  
- Cancel appointment  
- Track appointment status (`SCHEDULED`, `CANCELLED`, `COMPLETED`)  
- Appointment analytics (appointments per doctor)  

## 💰 Billing System
- Generate bill  
- Calculate tax  
- Generate immutable `BillSummary`  
- Pay bill  
- Factory-based bill creation  

## 📊 Analytics (Java 8 Streams)
- Doctors filtered by specialization  
- Average consultation fee  
- Appointment count per doctor  

## 💾 CSV Persistence
- Save data to CSV  
- Load data from CSV  
- Uses try-with-resources  

---

# 📦 Package Structure

## 1️⃣ Entity
Core domain models:
- `Person` (abstract)  
- `Doctor`  
- `Patient`  
- `Appointment`  
- `Bill`  
- `BillSummary` (immutable)  
- `AppointmentStatus` (enum)  
- `Payable` (interface)  

---

## 2️⃣ Service
Contains business logic:
- `DoctorService`  
- `PatientService`  
- `AppointmentService`  
- `BillingService`  

Responsibilities:
- Validation  
- Workflow coordination  
- Stream analytics  
- Business rule enforcement  

---

## 3️⃣ util
Reusable utilities:
- `DataStore<T>` (generic storage)  
- `Validator`  
- `CSVUtil`  
- `IdGenerator` (Singleton using `AtomicInteger`)  

---

## 4️⃣ Exception
Custom exceptions:
- `AppointmentNotFoundException`  
- `InvalidDataException`  

---

## 5️⃣ Constants
Application-wide constants:
- Tax rate  
- File paths  
- Configuration values  

---

## 6️⃣ Console
Handles user interaction and input/output.

---

## 7️⃣ Menu
Controls application navigation and routing.

---

## 8️⃣ test
Manual test runner and functional test scripts.

---

# 🧠 OOP Concepts Demonstrated

- Encapsulation  
- Inheritance (`Person → Doctor, Patient`)  
- Polymorphism  
- Abstraction  
- Interfaces (`Payable`)  
- Method overriding  
- Constructor chaining  
- Static members  
- Enums  
- Immutability (`BillSummary`)  
- Deep vs Shallow Copy (`clone()`)  

---

# 👨‍💻 Authors

Developed by **Manish Prajapat** and **Arindam Rathore** as part of the MediTrack learning assignment.  

This project demonstrates proficiency in Core Java, OOP principles, system design fundamentals, layered architecture, and structured application development.

---

# ▶️ Running the Application

## Run App
```bash
java -cp out meditrack.Main
```

## Run With CSV Load
```bash
java -cp out meditrack.Main --loadData
```

## Run Manual Tests
```bash
java -cp out meditrack.test.TestRunner
```

## Demo Instructions (Quick)
1. Add two doctors (option `1` twice)
2. Add one patient (option `2`)
3. Book appointment (option `3`)
4. List doctors (option `7`)
5. Open stream analytics (option `9`)
6. Check average fee (option `2` in Streams menu)

## Sample Run Output
```text
===== MediTrack =====
1. Add Doctor
2. Add Patient
3. Book Appointment
4. Cancel Appointment
5. Generate + Pay Bill
6. Search Patient (id/name/age)
7. List Doctors
8. Save Data to CSV
9. Streams Analytics
10. Exit
Choose: ... Doctor added: DOC1

Choose: ... Doctor added: DOC2

Choose: ... Patient created successfully. ID: PATIENT3
Patient added: PATIENT3

Choose: ... Appointment is Booked. appointmentId: APPOINTMENT4

Choose: Doctor{id='DOC1', name='Dr A', speciality=CARDIOLOGY, fee=100.0}
Doctor{id='DOC2', name='Dr B', speciality=GENERAL, fee=300.0}

Choose: Streams Menu
1. Filter doctors by speciality
2. Average consultation fee
3. Appointments per doctor
Choose: Average consultation fee: 200.0
```

## Streams + Lambdas Features
- Filter doctors by specialization
- Average doctor consultation fee
- Appointments per doctor analytics

These are available from menu option `9`.

## Documentation
- `docs/Setup_Instructions.md`
- `docs/JVM_Report.md`
- `docs/Design_Decisions.md`
- JavaDoc HTML: `docs/javadocs/index.html`

## YOU can go through the given video below for the walkthrough of the project
## Project Walkthrough Video
[Watch the Demonstration demo](https://drive.google.com/file/d/1ZIMY4cb2fpsNidu1BjXuaIcYD3uDNfD5/view?usp=drive_link)
