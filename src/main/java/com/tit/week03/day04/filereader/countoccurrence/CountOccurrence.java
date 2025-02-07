package com.tit.week03.day04.filereader.countoccurrence;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class CountOccurrence {
    public static void main(String[] args) {
        String filePath = "Sample.txt";
        String targetWord = "Java";
        int count = 0;

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Normalize case and split the line into words
                String[] words = line.toLowerCase().split("\\W+");

                for (String word : words) {
                    if (word.equals(targetWord.toLowerCase())) {
                        count++;
                    }
                }
            }

            System.out.println("The word '" + targetWord + "' appears " + count + " times in the file.");

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}

