package com.tit.week03.day06.runtimeanalysis.fibonaccicomparison;

public class FibonacciComparison {

    public static void main(String[] args) {
        int[] sizes = {10, 30, 50};

        for (int size : sizes) {
            System.out.println("Fibonacci Number: " + size);

            // Recursive Fibonacci
            if (size <= 30) {
                long recStart = System.nanoTime();
                long recResult = fibonacciRecursive(size);
                long recEnd = System.nanoTime();
                double recTime = (recEnd - recStart) / 1000000.0;
                System.out.println("Recursive Fibonacci Result: " + recResult);
                System.out.println("Recursive Fibonacci Time: " + recTime + " ms");
            } else {
                System.out.println("Recursive Fibonacci: Unfeasible");
            }

            // Iterative Fibonacci
            long iterStart = System.nanoTime();
            long iterResult = fibonacciIterative(size);
            long iterEnd = System.nanoTime();
            double iterTime = (iterEnd - iterStart) / 1000000.0;
            System.out.println("Iterative Fibonacci Result: " + iterResult);
            System.out.println("Iterative Fibonacci Time: " + iterTime + " ms");

            System.out.println("--------------------------------------");
        }
    }

    // Recursive Fibonacci
    public static long fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }


    // Iterative Fibonacci (O(N))
    public static long fibonacciIterative(int n) {
        if (n <= 1) return n;
        long a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}


