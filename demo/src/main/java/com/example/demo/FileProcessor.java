package com.example.demo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileProcessor {

    public static void main(String[] args) {
        String filename = "C:\\Users\\Admin\\javacode\\demo\\src\\main\\resources\\Numbers.txt";
        processFile(filename);
    }

    public static void processFile(String filename) {
        File file = new File(filename);
        double sum = 0;
        int count = 0;

        try {
            Scanner scanner=new Scanner(file);

            while (scanner.hasNextLine()) {
                String line=scanner.nextLine().trim();
                if (line.isEmpty())continue;

                Double number=parseNumber(line);
                if (number!=null) {
                    sum+=number;
                    count++;
                }
            }

            scanner.close();

            printResults(sum, count);

        } catch (FileNotFoundException e) {
            System.out.println("Error: File '" + filename + "' not found");
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    public static Double parseNumber(String line) {
        try {
            return Double.parseDouble(line);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format, skipping " + line);
            return null;
        }
    }

    public static void printResults(double sum, int count) {
        if (count > 0) {
            double average=sum/count;
            System.out.println("Total numbers: " + count);
            System.out.println("Sum: " + sum);
            System.out.println("Average: " + average);
        } else {
            System.out.println("No valid numbers to process.");
        }
    }
}
