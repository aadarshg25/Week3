package com.tit.week03.day06.runtimeanalysis.stringconcatenationcomparison;

public class StringConcatenationComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};

        for (int size : sizes) {
            System.out.println("Operations Count: " + size);

            // String Concatenation Performance
            if (size < 1000000) {
                long stringStart = System.nanoTime();
                stringConcatenation(size);
                long stringEnd = System.nanoTime();
                double stringTime = (stringEnd - stringStart) / 1000000.0;
                System.out.println("String Concatenation Time: " + stringTime + " ms");
            } else {
                System.out.println("String Concatenation Time: Unusable");
            }


            // StringBuilder Performance
            long stringBuilderStart = System.nanoTime();
            stringBuilderConcatenation(size);
            long stringBuilderEnd = System.nanoTime();
            double stringBuilderTime = (stringBuilderEnd - stringBuilderStart) / 1000000.0;
            System.out.println("StringBuilder Concatenation Time: " + stringBuilderTime + " ms");

            // StringBuffer Performance
            long stringBufferStart = System.nanoTime();
            stringBufferConcatenation(size);
            long stringBufferEnd = System.nanoTime();
            double stringBufferTime = (stringBufferEnd - stringBufferStart) / 1000000.0;
            System.out.println("StringBuffer Concatenation Time: " + stringBufferTime + " ms");

            System.out.println("-----------------------------------");
        }
    }

    // String Concatenation
    private static void stringConcatenation(int n) {
        String str = "";
        for (int i = 0; i < n; i++) {
            str += "a"; // Creates a new object every time
        }
    }

    // StringBuilder Concatenation
    private static void stringBuilderConcatenation(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
    }

    // StringBuffer Concatenation
    private static void stringBufferConcatenation(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
    }
}

