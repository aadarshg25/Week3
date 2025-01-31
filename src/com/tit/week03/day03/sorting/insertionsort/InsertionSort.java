package com.tit.week03.day03.sorting.insertionsort;

import java.util.Scanner;

class InsertionSort {
    public static void main(String[] args) {
        // Taking input for the employee IDs array
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of employees: ");
        int n = scanner.nextInt();

        int[] employeeIDs = new int[n];
        System.out.println("Enter the employee IDs:");
        for (int i = 0; i < n; i++) {
            employeeIDs[i] = scanner.nextInt();
        }

        // Sorting the employee IDs using Insertion Sort
        insertionSort(employeeIDs);

        // Displaying the sorted employee IDs
        System.out.println("Sorted Employee IDs in ascending order:");
        for (int id : employeeIDs) {
            System.out.print(id + " ");
        }

        scanner.close();
    }

    // Insertion Sort function
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) { // Start from the second element
            int key = arr[i]; // Current element to be placed correctly
            int j = i - 1;

            // Move elements that are greater than 'key' one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            // Insert the key at its correct position
            arr[j + 1] = key;
        }
    }
}

