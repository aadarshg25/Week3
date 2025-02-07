package com.tit.week03.day04.binarysearch.firstlastoccurrence;

public class FirstLastOccurrence {

    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                // Once we find the target, we stop and return the index of the first occurrence
                // We do not need to continue searching further
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;  // Element not found
    }


    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int lastOccurrence = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                // We found the target, so keep checking the right side for the last occurrence
                lastOccurrence = mid;
                left = mid + 1;  // Search in the right side
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return lastOccurrence;
    }


    public static int[] findFirstAndLastOccurrence(int[] arr, int target) {
        int first = findFirstOccurrence(arr, target);
        if (first == -1) {
            return new int[] {-1};  // Element not found
        }
        int last = findLastOccurrence(arr, target);
        return new int[] {first, last};
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 4, 5, 6};
        int target = 4;

        int[] result = findFirstAndLastOccurrence(arr, target);

        if (result[0] == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("First Occurrence: " + result[0]);
            System.out.println("Last Occurrence: " + result[1]);
        }
    }
}

