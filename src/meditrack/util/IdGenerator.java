package util;

public class IdGenerator {
    private static Integer currentDataId = 0;

    public static String generateID(String type) {
        currentDataId++;
        return type +Integer.toString(currentDataId);
    }


}
