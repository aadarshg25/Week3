package com.tit.week03.day03.sorting.bubblesort;

import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        // Taking input for the student marks array
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        int[] marks = new int[n];
        System.out.println("Enter the marks of students:");
        for (int i = 0; i < n; i++) {
            marks[i] = scanner.nextInt();
        }

        // Sorting the marks using Bubble Sort
        bubbleSort(marks);

        // Displaying the sorted marks
        System.out.println("Sorted student marks in ascending order:");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }

        scanner.close();
    }

    // Bubble Sort function
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) { // Outer loop for n-1 passes
            boolean swapped = false; // Flag to check if swapping occurred

            for (int j = 0; j < n - i - 1; j++) { // Inner loop for comparisons
                if (arr[j] > arr[j + 1]) {
                    // Swap adjacent elements if they are in the wrong order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no swaps occurred, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }
}

