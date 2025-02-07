package com.tit.week03.day04.filereader.readfile;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {

        String filePath = "Sample.txt";

        // Using try-with-resources to ensure automatic resource management
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {

            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}

