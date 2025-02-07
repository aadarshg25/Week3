package com.tit.week03.day04.inputstreamreader.readwrite;

import java.io.*;

public class ReadWrite {
    public static void main(String[] args) {
        String filePath = "Sample.txt";

        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
             FileWriter fileWriter = new FileWriter(filePath, true); // Append mode
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            System.out.println("Enter text (type 'exit' to stop):");

            String userInput;
            while (true) {
                userInput = bufferedReader.readLine(); // Read input from console

                if ("exit".equalsIgnoreCase(userInput)) {
                    break; // Stop if user types "exit"
                }

                bufferedWriter.write(userInput); // Write input to file
                bufferedWriter.newLine(); // Move to next line in the file
            }

            System.out.println("Input saved to " + filePath);

        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
