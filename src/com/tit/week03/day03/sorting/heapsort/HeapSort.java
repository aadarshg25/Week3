package com.tit.week03.day03.sorting.heapsort;

public class HeapSort {

    // To heapify a subtree rooted with node i which is an index in arr[]
    static void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // Left child index
        int right = 2 * i + 2; // Right child index

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            swap(arr, i, largest);

            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }

    // Utility function to swap two elements in the array
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Main function to perform heap sort
    static void heapSort(int[] arr) {
        int n = arr.length;

        // Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to the end
            swap(arr, 0, i);

            // Call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // Function to print the array
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Driver method to test the functionality
    public static void main(String[] args) {
        // Array of job applicants' salary demands
        int[] salaries = {9, 4, 3, 8, 10, 2, 5};

        System.out.println("Original salary demands:");
        printArray(salaries);

        // Perform heap sort to sort the salaries in ascending order
        heapSort(salaries);

        System.out.println("Sorted salary demands:");
        printArray(salaries);
    }
}

