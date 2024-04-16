package Que6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileHandler {
	
    private static void readTextFile(Scanner scanner) {
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("File content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    private static void writeToFile(Scanner scanner) {
        System.out.print("Enter the file path to write: ");
        String filePath = scanner.nextLine();

        System.out.print("Enter text to write to the file: ");
        String text = scanner.nextLine();

        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println(text);
            System.out.println("Text successfully written to the file.");
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }

    private static void analyzeFile(Scanner scanner) {
        System.out.print("Enter the file path to analyze: ");
        String filePath = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            Map<String, Integer> wordFrequency = new HashMap();

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");

                for (String word : words) {
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }

            int totalWords = wordFrequency.values().stream().mapToInt(Integer::intValue).sum();
            int uniqueWords = wordFrequency.size();

            System.out.println("Analysis Results:");
            System.out.println("Total number of words: " + totalWords);
            System.out.println("Number of unique words: " + uniqueWords);
            System.out.println("Word Frequency:");
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to File Handling and Analysis System!");
        System.out.println("Choose an option:");
        System.out.println("1. Read a Text File");
        System.out.println("2. Write to a Text File");
        System.out.println("3. Analyze File Content");
        System.out.print("Enter your choice (1, 2, or 3): ");
        
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
        case 1:
            readTextFile(scanner);
            break;
        case 2:
            writeToFile(scanner);
            break;
        case 3:
            analyzeFile(scanner);
            break;
        default:
            System.out.println("Invalid choice. Exiting...");
    }

	}

}
