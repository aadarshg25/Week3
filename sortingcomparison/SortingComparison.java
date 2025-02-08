package com.tit.week03.day06.runtimeanalysis.sortingcomparison;

import java.util.Arrays;
import java.util.Random;

public class SortingComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};

        for (int size : sizes) {
            int[] dataset = generateRandomArray(size);

            System.out.println("Dataset Size: " + size);

            // Bubble Sort Performance
            if (size <= 10000) { // Only run Bubble Sort for smaller datasets
                int[] bubbleArray = Arrays.copyOf(dataset, dataset.length);
                long bubbleStart = System.nanoTime();
                bubbleSort(bubbleArray);
                long bubbleEnd = System.nanoTime();
                double bubbleTime = (bubbleEnd - bubbleStart) / 1000000.0;
                System.out.println("Bubble Sort Time: " + bubbleTime + " ms");
            } else {
                System.out.println("Bubble Sort Time: Unfeasible");
            }


            // Merge Sort Performance
            int[] mergeArray = Arrays.copyOf(dataset, dataset.length);
            long mergeStart = System.nanoTime();
            mergeSort(mergeArray, 0, mergeArray.length - 1);
            long mergeEnd = System.nanoTime();
            double mergeTime = (mergeEnd - mergeStart) / 1000000.0;
            System.out.println("Merge Sort Time: " + mergeTime + " ms");

            // Quick Sort Performance
            int[] quickArray = Arrays.copyOf(dataset, dataset.length);
            long quickStart = System.nanoTime();
            quickSort(quickArray, 0, quickArray.length - 1);
            long quickEnd = System.nanoTime();
            double quickTime = (quickEnd - quickStart) / 1000000.0;
            System.out.println("Quick Sort Time: " + quickTime + " ms");

            System.out.println("-----------------------------------");
        }
    }

    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }
        return array;
    }

    // Bubble Sort
    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Merge Sort
    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }


        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];
    }

    // Quick Sort
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}

