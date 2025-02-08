package com.tit.week03.day06.runtimeanalysis.filereadingcomparison;

import java.io.*;

public class FileReadingComparison {
    public static void main(String[] args) {
        String filePath = "Sample.txt";

        System.out.println("Reading File: " + filePath);

        // FileReader
        long fileReaderStart = System.nanoTime();
        readUsingFileReader(filePath);
        long fileReaderEnd = System.nanoTime();
        double fileReaderTime = (fileReaderEnd - fileReaderStart) / 1000000.0;
        System.out.println("FileReader Time: " + fileReaderTime + " ms");

        // InputStreamReader
        long inputStreamStart = System.nanoTime();
        readUsingInputStreamReader(filePath);
        long inputStreamEnd = System.nanoTime();
        double inputStreamTime = (inputStreamEnd - inputStreamStart) / 1000000.0;
        System.out.println("InputStreamReader Time: " + inputStreamTime + " ms");
    }

    // FileReader
    private static void readUsingFileReader(String filePath) {
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            while (bufferedReader.read() != -1) {} // Read character-by-character

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // InputStreamReader
    private static void readUsingInputStreamReader(String filePath) {
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            while (bufferedReader.read() != -1) {} // Read character-by-character

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

