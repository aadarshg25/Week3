package com.tit.week03.day04.stringbuilder.removeduplicates;
import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();

            String result = removeDuplicates(input);
            System.out.println("String without duplicates: " + result);
        }
    }

    public static String removeDuplicates(String input) {
        StringBuilder string = new StringBuilder();
        HashSet<Character> unique = new HashSet<>();

        for (char ch : input.toCharArray()) {
            if (unique.add(ch)) {
                string.append(ch);
            }
        }
        return string.toString();
    }
}

