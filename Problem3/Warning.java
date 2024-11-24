package Problem3;

import java.io.*;
import java.util.Scanner;

public class Warning {
    public static void main(String[] args) {
        String inputName = "students.dat";
        String outputName = "warning.dat";

        try {
            Scanner scan = new Scanner(new File(inputName));
            PrintWriter outFile = new PrintWriter(new FileWriter(outputName));

            outFile.println("Students on Academic Warning");
            outFile.println();

            while (scan.hasNext()) {
                String name = scan.next();
                int creditHrs = scan.nextInt();
                double qualityPts = scan.nextDouble();

                double gpa = qualityPts / creditHrs;

                if ((creditHrs < 30 && gpa < 1.5) ||
                        (creditHrs < 60 && gpa < 1.75) ||
                        (creditHrs >= 60 && gpa < 2.0)) {
                    outFile.printf("%s %d %.2f%n", name, creditHrs, gpa);
                }
            }

            scan.close();
            outFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file " + inputName + " was not found.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Format error in input file: " + e.getMessage());
        }
    }
}

