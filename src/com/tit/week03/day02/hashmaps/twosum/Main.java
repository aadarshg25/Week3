package com.tit.week03.day02.hashmaps.twosum;

import java.util.HashMap;

class Main {
     static int[] twoSum(int[] arr, int target) {
         HashMap<Integer,Integer> hm = new HashMap<>();
         for(int i =0;i<arr.length;i++){
             int rem = target - arr[i];
             if(hm.containsKey(rem)){
                 return new int[]{hm.get(rem),i};
             }
             if(!hm.containsKey(arr[i])){
                 hm.put(arr[i],i);
             }
         }
         return new int[]{-1,-1};

     }
    public static void main(String[] args) {
        int nums[] = {2,11,15,7};
        int target = 9;

        int ans [] = twoSum(nums,target);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
