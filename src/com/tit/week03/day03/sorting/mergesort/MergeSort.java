package com.tit.week03.day03.sorting.mergesort;

import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        // Taking input for book prices array
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of book prices: ");
        int n = scanner.nextInt();

        int[] prices = new int[n];
        System.out.println("Enter the book prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        // Sorting the book prices using Merge Sort
        mergeSort(prices, 0, n - 1);

        // Displaying the sorted book prices
        System.out.println("Sorted book prices in ascending order:");
        for (int price : prices) {
            System.out.print(price + " ");
        }

        scanner.close();
    }

    // Merge Sort function
    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        // Finding the middle index
        int mid = left + (right - left) / 2;

        // Recursively sorting the two halves
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        // Merging the sorted halves
        merge(arr, left, mid, right);
    }

    // Merge function to merge two sorted halves
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1; // Size of left subarray
        int n2 = right - mid;    // Size of right subarray

        // Creating temporary subarrays
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Copying data to temp arrays
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left; // Initial indices

        // Merging the arrays in sorted order
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        // Copying remaining elements from left subarray
        while (i < n1) {
            arr[k++] = leftArr[i++];
        }

        // Copying remaining elements from right subarray
        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
    }
}
