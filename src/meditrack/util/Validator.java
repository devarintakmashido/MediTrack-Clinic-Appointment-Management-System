package meditrack.util;

import java.time.LocalDate;

public class Validator {

    public static boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }

    public static boolean isValidNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.length() != 10) {
            return false;
        }
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (!Character.isDigit(phoneNumber.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidDate(LocalDate dateOfAppointment) {
        return dateOfAppointment != null && !dateOfAppointment.isBefore(LocalDate.now());
    }
}
