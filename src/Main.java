import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Diary diary = new Diary("diary.txt");

        // 1. Write until the user types "exit"
        System.out.println("Write your notes (type exit to stop):");
        String line = sc.nextLine();
        while (!line.equals("exit")) {
            try {
                diary.addLine(line);
            } catch (IOException e) {
                System.out.println("Could not write: " + e.getMessage());
            }
            line = sc.nextLine();
        }

        // 2. Read and show the diary
        System.out.println("\n=== My diary ===");
        try {
            int lines = diary.show();
            System.out.println(lines + " lines, " + diary.getSize() + " bytes");
        } catch (FileNotFoundException e) {
            System.out.println("The diary is empty");
        }

        // Extra: delete the diary
        System.out.print("\nDelete the diary? (y/n): ");
        if (sc.nextLine().equals("y")) {
            diary.delete();
            System.out.println("Diary deleted");
        }
    }
}
