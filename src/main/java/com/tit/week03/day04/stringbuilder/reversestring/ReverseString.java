package com.tit.week03.day04.stringbuilder.reversestring;

import java.util.Scanner;

public class ReverseString {
    public String reverse(String input) {
        StringBuilder stringBuilder = new StringBuilder(input);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();
            System.out.println("Reversed String: " + new ReverseString().reverse(input));
        }
    }
}

