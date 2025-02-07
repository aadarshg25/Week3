package com.tit.week03.day04.challengeproblem.filereaderVsinputstreamreader;
import java.io.*;

public class FileReaderVsInputStreamReader {
    public static void main(String[] args) {
        String filePath = "Sample.txt";

        // FileReader Test
        long startTime = System.nanoTime();
        int wordCount = countWordsUsingFileReader(filePath);
        long endTime = System.nanoTime();
        System.out.println("FileReader - Word Count: " + wordCount + ", Time: " + (endTime - startTime) / 1000000 + " ms");

        // InputStreamReader Test
        startTime = System.nanoTime();
        wordCount = countWordsUsingInputStreamReader(filePath);
        endTime = System.nanoTime();
        System.out.println("InputStreamReader - Word Count: " + wordCount + ", Time: " + (endTime - startTime) / 1000000 + " ms");
    }

    private static int countWordsUsingFileReader(String filePath) {
        int wordCount = 0;
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.out.println("Error reading file with FileReader: " + e.getMessage());
        }
        return wordCount;
    }

    private static int countWordsUsingInputStreamReader(String filePath) {
        int wordCount = 0;
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.out.println("Error reading file with InputStreamReader: " + e.getMessage());
        }
        return wordCount;
    }
}

