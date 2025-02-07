package com.tit.week03.day04.challengeproblem.linearsearch;
import java.util.HashSet;

public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }

        for (int i = 1; i <= nums.length + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        System.out.println("First missing positive: " + firstMissingPositive(nums));
    }
}


