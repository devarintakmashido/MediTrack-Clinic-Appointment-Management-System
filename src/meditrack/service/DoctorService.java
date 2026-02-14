package meditrack.service;

import com.airtribe.meditrack.Myinterface.Searchable;
import com.airtribe.meditrack.entity.Doctor;
import com.airtribe.meditrack.util.DataStore;

public class DoctorService implements Searchable<Doctor> {

    private final DataStore<Doctor> store = new DataStore<>();

    public void addDoctor(Doctor doctor) {
        store.save(doctor.getId(), doctor);
    }

    @Override
    public Doctor findById(String id) {
        return store.findById(id);
    }
}
