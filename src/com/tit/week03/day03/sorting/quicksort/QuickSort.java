package com.tit.week03.day03.sorting.quicksort;

import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        // Taking input for product prices
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of products: ");
        int n = scanner.nextInt();

        int[] prices = new int[n];
        System.out.println("Enter the product prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        // Sorting the product prices using Quick Sort
        quickSort(prices, 0, n - 1);

        // Displaying the sorted product prices
        System.out.println("Sorted product prices in ascending order:");
        for (int price : prices) {
            System.out.print(price + " ");
        }

        scanner.close();
    }

    // Partition function
    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int count = 0;

        // Count elements less than or equal to pivot
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] <= pivot) count++;
        }

        // Place pivot in its correct position
        int pivotIndex = start + count;
        swap(arr, pivotIndex, start);

        // Rearranging elements based on pivot
        int i = start, j = end;
        while (i < pivotIndex && j > pivotIndex) {
            while (arr[i] <= pivot) i++;
            while (arr[j] > pivot) j--;
            if (i < pivotIndex && j > pivotIndex) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        return pivotIndex;
    }

    // Quick Sort function
    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;

        int pivotIndex = partition(arr, start, end);
        quickSort(arr, start, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, end);
    }

    // Swap function
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
