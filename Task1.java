# File-Handling
  import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class Task1 {

    // Method to write to a file (overwrites if exists)
    public static void writeToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println(" Writing to the file was successful.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    // Method to read from a file
    public static void readFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println(" File content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    // Method to modify a file by replacing a string
    public static void modifyFile(String filePath, String target, String replacement) {
        try {
            Path path = Paths.get(filePath);
            String content = new String(Files.readAllBytes(path));
            content = content.replaceAll(target, replacement);
            Files.write(path, content.getBytes());
            System.out.println(" File modified successfully.");
        } catch (IOException e) {
            System.out.println(" Error modifying the file: " + e.getMessage());
        }
    }

    // Main method to test functionalities
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = "sample.txt";

        System.out.println("Choose an option: 1 - Write, 2 - Read, 3 - Modify");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                System.out.println("Enter content to write:");
                String content = scanner.nextLine();
                writeToFile(filePath, content);
                break;

            case 2:
                System.out.println("Reading content from the file:");
                readFromFile(filePath);
                break;

            case 3:
                System.out.println("Enter word to replace:");
                String target = scanner.nextLine();
                System.out.println("Enter replacement word:");
                String replacement = scanner.nextLine();
                modifyFile(filePath, target, replacement);
                break;

            default:
                System.out.println("Invalid option.");
        }

        scanner.close();
    }
}
