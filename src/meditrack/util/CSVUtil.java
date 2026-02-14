package meditrack.util;

import java.io.FileWriter;
import java.io.IOException;

public class CSVUtil {

    public static void writeLine(String file, String line) throws IOException {
        FileWriter fw = new FileWriter(file, true);
        fw.write(line + "\n");
        fw.close();
    }
}
