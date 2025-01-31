package com.tit.week03.day03.sorting.countingsort;

import java.util.Scanner;

public class CountingSort {
    public static void main(String[] args) {
        // Taking input for student ages array
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        int[] ages = new int[n];
        System.out.println("Enter the student ages (between 10 and 18):");
        for (int i = 0; i < n; i++) {
            ages[i] = scanner.nextInt();
        }

        // Sorting the student ages using Counting Sort
        countingSort(ages);

        // Displaying the sorted student ages
        System.out.println("Sorted student ages in ascending order:");
        for (int age : ages) {
            System.out.print(age + " ");
        }

        scanner.close();
    }

    // Function to find the maximum element in the array
    public static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // Counting Sort function
    public static void countingSort(int[] arr) {
        int max = findMax(arr); // Find the maximum value in the array
        int[] count = new int[max + 1]; // Frequency array

        // Step 1: Count occurrences of each age
        for (int num : arr) {
            count[num]++;
        }

        // Step 2: Place elements in sorted order
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }
}

