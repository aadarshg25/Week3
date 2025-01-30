package com.tit.week03.day02.hashmaps.findallsubarrayswithzerosum;

import java.util.HashMap;

public class Main {
    static void findSubarrayWithSum(int [] arr){
        HashMap<Integer , Integer> map = new HashMap<>();
        int n = arr.length;
        boolean isFound = false;
        int cumulativeSum = 0;
        // for the subarray from start of the array
        map.put(0 , -1);
        for(int i = 0 ; i<n ; i++){
            cumulativeSum += arr[i];
            if(map.containsKey(cumulativeSum)){
                int start = map.get(cumulativeSum) + 1;
                isFound = true;
                System.out.println("Subarray With 0 Found From index " + start + " to " + i);
            }
            map.put(cumulativeSum , i);
        }
        if(!isFound){
            System.out.println("No Subarray Found");
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 3, 1, -2, -1};
        findSubarrayWithSum(arr);
    }
}
