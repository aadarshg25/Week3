package com.tit.week03.day02.stackandqueue.slidingwindowmaximum;

import java.util.Deque;
import java.util.LinkedList;


public class Main {
    static void display(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static int[] maxSlidingWindow(int[] arr, int k) {

        Deque<Integer> dq = new LinkedList<>();
        int n = arr.length;
        int ans []= new int[n-k+1];
        int j =0;
        for(int i=0;i<n;i++){
            //maintain the window
            if(!dq.isEmpty() && dq.getFirst() <= i-k){
                dq.remove(); // if the first is outside the window
            }

            //to keep in decreasing
            while(!dq.isEmpty() && arr[dq.getLast()] <= arr[i]){
                dq.removeLast(); // as we are smaller
            }

            dq.add(i);

            if(i>=k-1){ // as each step after the first window we need a ans
                ans[j++] = arr[dq.getFirst()];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        display(nums);
        int ans[] = maxSlidingWindow(nums,k);
        display(ans);
    }
}
