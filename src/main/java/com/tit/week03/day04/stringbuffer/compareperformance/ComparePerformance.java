package com.tit.week03.day04.stringbuffer.compareperformance;

public class ComparePerformance {
    public static long[] measureTime(StringBuilder stringBuilder , StringBuffer stringBuffer){
        long start = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            stringBuilder.append("Hello");
        }
        long end = System.nanoTime();
        long timeTakenByStringBuilder = end-start;

        start = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            stringBuffer.append("Hello");
        }
        end = System.nanoTime();
        long timeTakenByStringBuffer = end-start;

        return new long[]{timeTakenByStringBuilder,timeTakenByStringBuffer};
    }
    public static boolean isFast(long [] time){
        if(time[0] < time[1]){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("StringBuilder");
        StringBuffer stringBuffer = new StringBuffer("StringBuffer");
        long arr[] = measureTime(stringBuilder,stringBuffer);
        System.out.println("StringBuilder is taking less time than StringBuffer : " + isFast(arr));
        System.out.println("StringBuilder : " + arr[0] + " ns");
        System.out.println("StringBuffer : " + arr[1] + " ns");
    }
}
