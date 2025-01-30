package com.tit.week03.day02.stackandqueue.sortastackusingrecursion;

import java.util.Stack;

class Main {
    static Stack<Integer> sortUsingRecurrsion(Stack<Integer> st) {
        // Base case: If stack has 1 or no elements, it's already sorted
        if (st.size() <= 1) {
            return st;
        }

        // Pop the top element
        int top = st.pop();

        // Recursively sort the remaining stack
        sortUsingRecurrsion(st);

        // Insert 'top' back in sorted order
        Stack<Integer> tempStack = new Stack<>(); //as we dont know when to add it
        while (!st.isEmpty() && top > st.peek()) {
            tempStack.push(st.pop());
        }
        st.push(top);
        while (!tempStack.isEmpty()) {
            st.push(tempStack.pop());
        }

        return st;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(8);
        stack.push(1);
        stack.push(2);
        stack.push(5);

        System.out.println("Original Stack: " + stack);
        sortUsingRecurrsion(stack);
        System.out.println("Sorted Stack: " + stack);
    }
}
