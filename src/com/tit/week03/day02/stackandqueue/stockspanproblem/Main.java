package com.tit.week03.day02.stackandqueue.stockspanproblem;

import java.util.Stack;

public class Main {
    public static int[] stockSpan(int[] arr) {
        int n = arr.length;
        int res[] = new int[n];
        Stack<Integer> st = new Stack<>();
        res[0] = 1;
        st.push(0);

        for (int i = 1; i < n; i++) {
            while (st.size() > 0 && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            if (st.size() == 0) {
                res[i] = i + 1;
            } else {
                res[i] = i - st.peek();
            }
            st.push(i);

        }
        return res;

    }
    public static void main(String[] args) {
        int price[] = {100,80,60, 70, 60, 75, 85};
        System.out.println("Price : ");
        for (int i = 0; i < price.length; i++) {
            System.out.print(price[i] + " ");
        }
        System.out.println();

        int res[] = stockSpan(price);

        System.out.println("Span : ");
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

    }
}
