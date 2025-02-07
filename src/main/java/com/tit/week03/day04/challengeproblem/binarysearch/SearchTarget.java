package com.tit.week03.day04.challengeproblem.binarysearch;
import java.util.Arrays;

public class SearchTarget {

    public static int binarySearch(int[] arr, int target) {

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1; // Search left half
            } else {
                left = mid + 1; // Search right half
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 4, 1};
        int target = 4;

        int index = binarySearch(arr, target);
        if (index != -1) {
            System.out.println("Target " + target + " found at index " + index);
        } else {
            System.out.println("Target " + target + " not found.");
        }
    }
}
