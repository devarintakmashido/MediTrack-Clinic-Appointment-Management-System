package meditrack.util;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
    private static final AtomicInteger currentDataId = new AtomicInteger(0);

    public static String generateID(String type) {
        int id = currentDataId.incrementAndGet();
        return type + id;
    }
}
