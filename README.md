# MediTrack (Java Console App)

MediTrack is a beginner-friendly Java backend project for managing:
- Doctors
- Patients
- Appointments
- Billing
- CSV persistence
- Streams/Lambda analytics

## Project Structure
- `src/meditrack/Entity`
- `src/meditrack/Service`
- `src/meditrack/Repositories`
- `src/meditrack/util`
- `src/meditrack/Exception`
- `src/meditrack/constants`
- `src/meditrack/test`
- `docs/`

## Compile
```bash
cd /Users/arindamrathore26/IdeaProjects/MediTrackGroup
rm -rf out
javac -d out $(find src -name '*.java')
```

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
[Watch the Demonstration demo](https://drive.google.com/file/d/1iLfEI21VFIWX4pquvck96QrryV0ZnNHM/view?usp=sharing)
