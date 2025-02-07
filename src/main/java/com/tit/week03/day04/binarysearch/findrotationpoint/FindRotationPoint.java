package com.tit.week03.day04.binarysearch.findrotationpoint;

public class FindRotationPoint {
    public static int findRotationPoint(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right]) {
                // Minimum element is in the right half
                left = mid + 1;
            } else {
                // Minimum element is in the left half (including mid)
                right = mid;
            }
        }
        return left; // Index of the smallest element (rotation point)
    }

    public static void main(String[] args) {
        int[] arr = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        int rotationIndex = findRotationPoint(arr);
        System.out.println("Rotation point index: " + rotationIndex);
        System.out.println("Smallest element: " + arr[rotationIndex]);
    }
}

