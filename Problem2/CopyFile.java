package Problem2;

import java.util.Scanner;
import java.io.*;

public class CopyFile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        File inputFile = null;
        Scanner fileScanner = null;

        while (true) {
            System.out.print("Enter the filename: ");
            String filename = scan.nextLine();

            try {
                inputFile = new File(filename);
                fileScanner = new Scanner(inputFile);
                break; // Exit loop when the file is valid
            } catch (FileNotFoundException e) {
                System.out.println("File not found. Please try again.");
            }
        }

        System.out.println("File content:");
        while (fileScanner.hasNextLine()) {
            System.out.println(fileScanner.nextLine());
        }
    }
}

