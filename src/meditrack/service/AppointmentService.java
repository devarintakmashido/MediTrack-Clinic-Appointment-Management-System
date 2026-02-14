package meditrack.service;

import com.airtribe.meditrack.Myinterface.Searchable;
import com.airtribe.meditrack.entity.Appointment;
import com.airtribe.meditrack.exception.AppointmentNotFoundException;
import com.airtribe.meditrack.util.CSVUtil;
import com.airtribe.meditrack.util.DataStore;

public class AppointmentService implements Searchable<Appointment> {

    private final DataStore<Appointment> store = new DataStore<>();

    public void book(Appointment appointment) {
        store.save(appointment.getId(), appointment);
    }

    @Override
    public Appointment findById(String id) {
        return store.findById(id);
    }
    public void completeAppointment(String appointmentId) throws AppointmentNotFoundException {

        Appointment appointment = store.findById(appointmentId);

        if (appointment == null) {
            throw new AppointmentNotFoundException("Appointment not found with id: " + appointmentId);
        }

        appointment.markCompleted(); // or setStatus(COMPLETED)
    }


    public void exportAppointmentsToCSV(String fileName) throws Exception {

        CSVUtil.writeLine(fileName, "AppointmentId,DoctorId,PatientId,Date,Status");

        for (Appointment a : store.findAll()) {
            CSVUtil.writeLine(fileName,
                    a.getId() + "," +
                            a.getDoctorId() + "," +
                            a.getPatientId() + "," +
                            a.getDate() + "," +
                            a.getStatus());
        }
    }


}
