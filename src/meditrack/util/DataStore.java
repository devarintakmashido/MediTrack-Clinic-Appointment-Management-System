package meditrack.util;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DataStore<T extends Serializable> {

    private Map<String, T> store = new HashMap<>();

    public void save(String id, T obj) {
        store.put(id, obj);
    }

    public T findById(String id) {
        return store.get(id);
    }

    public Collection<T> findAll() {
        return store.values();
    }

    public void serialize(String file) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(store);
        oos.close();
    }

    public void deserialize(String file) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        store = (Map<String, T>) ois.readObject();
        ois.close();
    }
}
