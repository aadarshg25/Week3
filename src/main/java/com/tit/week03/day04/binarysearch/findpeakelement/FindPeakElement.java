package com.tit.week03.day04.binarysearch.findpeakelement;

public class FindPeakElement {
        public static int findPeakElement(int[] arr) {
            int left = 0, right = arr.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                // Check if mid is a peak element
                if ((mid == 0 || arr[mid] > arr[mid - 1]) && (mid == arr.length - 1 || arr[mid] > arr[mid + 1])) {
                    return mid; // Mid is the peak element
                }

                // If left neighbor is greater, search left half
                if (mid > 0 && arr[mid - 1] > arr[mid]) {
                    right = mid - 1;
                }
                // Otherwise, search right half
                else {
                    left = mid + 1;
                }
            }
            return -1; // This case will never occur if a peak always exists
        }

        public static void main(String[] args) {
            int[] arr = {1, 3, 20, 4, 1, 0};
            int peakIndex = findPeakElement(arr);
            System.out.println("Peak element index: " + peakIndex);
            System.out.println("Peak element: " + arr[peakIndex]);
        }
}
