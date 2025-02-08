package com.tit.week03.day06.runtimeanalysis.datastructuresearchcomparison;

import java.util.*;

public class DataStructureSearchComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 100000, 1000000};
        Random random = new Random();

        for (int size : sizes) {
            int[] dataset = generateRandomArray(size);
            int target = dataset[random.nextInt(size)]; // Pick a random element to search

            System.out.println("Dataset Size: " + size);

            // Array Search
            long arrayStart = System.nanoTime();
            boolean arrayFound = linearSearch(dataset, target);
            long arrayEnd = System.nanoTime();
            double arrayTime = (arrayEnd - arrayStart) / 1000000.0;
            System.out.println("Array Search Time: " + arrayTime + " ms");

            // HashSet Search
            HashSet<Integer> hashSet = new HashSet<>();
            for (int num : dataset) hashSet.add(num);

            long hashSetStart = System.nanoTime();
            boolean hashSetFound = hashSet.contains(target);
            long hashSetEnd = System.nanoTime();
            double hashSetTime = (hashSetEnd - hashSetStart) / 1000000.0;
            System.out.println("HashSet Search Time: " + hashSetTime + " ms");

            // TreeSet Search
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int num : dataset) treeSet.add(num);

            long treeSetStart = System.nanoTime();
            boolean treeSetFound = treeSet.contains(target);
            long treeSetEnd = System.nanoTime();
            double treeSetTime = (treeSetEnd - treeSetStart) / 1000000.0;
            System.out.println("TreeSet Search Time: " + treeSetTime + " ms");

            System.out.println("-----------------------------------");
        }
    }

    // Generate random dataset
    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size * 10); // Ensures unique large range of numbers
        }
        return array;
    }

    // Linear search in an array
    private static boolean linearSearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) return true;
        }
        return false;
    }
}

