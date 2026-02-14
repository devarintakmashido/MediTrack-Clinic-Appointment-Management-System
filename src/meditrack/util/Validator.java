package util;

import java.time.LocalDate;

public class Validator {

    public static boolean isValidEmail(String email){
        return email.contains("@")&& email.contains(".");
    }

    public static boolean isValidNumber(String phoneNumber){
        if (phoneNumber == null) return false;
        if (phoneNumber.length() != 10) return false;
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (!Character.isDigit(phoneNumber.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidDate(LocalDate dateOfAppointment) {

        return dateOfAppointment.isAfter(LocalDate.now());
    }
}
