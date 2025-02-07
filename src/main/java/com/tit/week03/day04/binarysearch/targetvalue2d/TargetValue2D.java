package com.tit.week03.day04.binarysearch.targetvalue2d;

public class TargetValue2D {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false; // Handle empty matrix
        }
        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = (rows * cols) - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Convert 1D index to 2D row and column
            int row = mid / cols;
            int col = mid % cols;
            int midValue = matrix[row][col];

            if (midValue == target) {
                return true; // Found the target
            } else if (midValue < target) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
        return false; // Target not found
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;
        System.out.println("Is target present? " + searchMatrix(matrix, target));
    }
}
