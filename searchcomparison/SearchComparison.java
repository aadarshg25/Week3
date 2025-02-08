package com.tit.week03.day06.runtimeanalysis.searchcomparison;
import java.util.Arrays;
import java.util.Random;

public class SearchComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        int target = -1; //For worst-case scenario

        for (int size : sizes) {
            int[] dataset = generateRandomArray(size);

            // Linear Search Performance
            long linearStart = System.nanoTime();
            linearSearch(dataset, target);
            long linearEnd = System.nanoTime();
            double linearTime = (linearEnd - linearStart) / 1000000.0;

            // Binary Search Performance (after sorting)
            Arrays.sort(dataset);
            long binaryStart = System.nanoTime();
            binarySearch(dataset, target);
            long binaryEnd = System.nanoTime();
            double binaryTime = (binaryEnd - binaryStart) / 1000000.0;

            System.out.println("Dataset Size: " + size);
            System.out.println("Linear Search Time: " + linearTime + " ms");
            System.out.println("Binary Search Time: " + binaryTime + " ms");
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

    private static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid; // Found target
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
