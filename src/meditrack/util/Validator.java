package meditrack.util;

import com.airtribe.meditrack.exception.InvalidDataException;

public class Validator {

    public static void notNull(Object o, String msg)
            throws InvalidDataException {
        if (o == null) throw new InvalidDataException(msg);
    }
}
