package meditrack.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVUtil {

    public static void writeLine(String file, String line) throws IOException {
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(line + "\n");
        }
    }

    public static List<String[]> readAll(String file) throws IOException {
        List<String[]> rows = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    rows.add(line.split(","));
                }
            }
        }
        return rows;
    }
}
