package util;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataStore<T> {

    private final List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public void remove(T item) {
        items.remove(item);
    }

    public List<T> getAll() {
        return new ArrayList<>(items); // defensive copy
    }

    public Optional<T> findFirst(java.util.function.Predicate<T> predicate) {
        return items.stream().filter(predicate).findFirst();
    }
}