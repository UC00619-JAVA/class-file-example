import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Diary {

    private final File file;

    public Diary(String fileName) {
        File folder = new File("data");
        if (!folder.exists()) {
            folder.mkdir();               // create the folder the first time
        }
        file = new File(folder, fileName);
    }

    // Adds a line at the end of the file (true = append)
    public void addLine(String text) throws IOException {
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(text + "\n");
        }
    }

    // Shows all lines, numbered, and returns how many there are
    public int show() throws FileNotFoundException {
        int number = 0;
        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                number++;
                System.out.println(number + ": " + reader.nextLine());
            }
        }
        return number;
    }

    public long getSize() {
        return file.length();
    }

    // Extra
    public boolean delete() {
        return file.delete();
    }
}
