package com.tit.week03.day03.sorting.selectionsort;

import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        // Taking input for exam scores
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        int[] scores = new int[n];
        System.out.println("Enter the exam scores:");
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }

        // Sorting the exam scores using Selection Sort
        selectionSort(scores);

        // Displaying the sorted exam scores
        System.out.println("Sorted exam scores in ascending order:");
        for (int score : scores) {
            System.out.print(score + " ");
        }

        scanner.close();
    }

    // Selection Sort function
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Finding the index of the minimum element in the remaining unsorted part
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swapping the found minimum element with the first element of the unsorted part
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}

