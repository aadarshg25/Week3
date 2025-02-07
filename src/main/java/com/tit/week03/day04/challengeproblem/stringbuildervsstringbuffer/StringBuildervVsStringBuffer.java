package com.tit.week03.day04.challengeproblem.stringbuildervsstringbuffer;


public class StringBuildervVsStringBuffer {
    public static void main(String[] args) {
        int iterations = 1000000;
        String text = "hello";

        // StringBuilder Performance Test
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuilder Time: " + (endTime - startTime) / 1000000 + " ms");

        // StringBuffer Performance Test
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer Time: " + (endTime - startTime) / 1000000 + " ms");
    }
}

