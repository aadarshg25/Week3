package com.tit.week03.day04.inputstreamreader.convertstream;

import java.io.*;

public class ConvertStream {
    public static void main(String[] args) {
        String filePath = "Sample.txt";
        String charset = "UTF-8";

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, charset);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (UnsupportedEncodingException e) {
            System.out.println("Encoding not supported: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}

