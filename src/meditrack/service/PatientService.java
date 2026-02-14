package meditrack.service;

import com.airtribe.meditrack.Myinterface.Searchable;
import com.airtribe.meditrack.entity.Patient;
import com.airtribe.meditrack.util.DataStore;

public class PatientService implements Searchable<Patient> {

    private final DataStore<Patient> store = new DataStore<>();

    public void addPatient(Patient patient) {
        store.save(patient.getId(), patient);
    }

    @Override
    public Patient findById(String id) {
        return store.findById(id);
    }
}
