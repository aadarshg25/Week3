package com.tit.week03.day02.stackandqueue.circulartour;

import java.util.LinkedList;
import java.util.Queue;

class Main {
     static int findStartingPump(int[][] pumps) {
        int n = pumps.length;
        Queue<Integer> queue = new LinkedList<>();
        int start = 0, positiveSum = 0, negativeSum = 0;

        for (int i = 0; i < n; i++) {
            positiveSum += pumps[i][0] - pumps[i][1]; // Petrol - Distance
            queue.add(i); // Add current pump to the queue

            // If positiveSum goes negative, reset queue and move start point
            if (positiveSum < 0) {
                start = i + 1; // Move start to next pump
                negativeSum += positiveSum; // Store negative balance
                positiveSum = 0;  // Reset positiveSum
                queue.clear(); // Clear queue since we restart
            }
        }

        // If total positiveSum + negativeSum is non-negative, tour is possible
        return (positiveSum + negativeSum >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        int[][] pumps = {
                {4, 6},
                {6, 5},
                {7, 3},
                {4, 5}
        };

        int startPump = findStartingPump(pumps);

        if (startPump == -1) {
            System.out.println("NO");
        } else {
            System.out.println("YES, start at pump: " + startPump);
        }
    }
}

