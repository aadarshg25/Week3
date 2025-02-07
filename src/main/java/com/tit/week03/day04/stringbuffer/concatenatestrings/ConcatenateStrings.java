package com.tit.week03.day04.stringbuffer.concatenatestrings;

import java.util.Scanner;

public class ConcatenateStrings {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of strings: ");
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume newline character after the number

            String[] inputStrings = new String[n];

            System.out.println("Enter the strings:");
            for (int i = 0; i < n; i++) {
                inputStrings[i] = scanner.nextLine();
            }

            String result = concatenateStrings(inputStrings);
            System.out.println("Concatenated String: " + result);
        }
    }

    public static String concatenateStrings(String[] inputStrings) {
        StringBuffer stringBuffer = new StringBuffer();

        for (String str : inputStrings) {
            stringBuffer.append(str);
        }

        return stringBuffer.toString();
    }
}

