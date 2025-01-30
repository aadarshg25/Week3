package com.tit.week03.day02.stackandqueue.queueusingstacks;

import java.util.Stack;

class QueueImplemented <T> {
    Stack<T> forward;
    Stack<T> backward;
    QueueImplemented(){
        forward = new Stack<>();
        backward = new Stack<>();
    }

     void enqueue(T data){
        forward.push(data);

     }

     T dequeue(){
        while (forward.size() >1){
            backward.push(forward.pop());
        }
        T element = forward.pop();
        while (backward.size() >0){
            forward.push(backward.pop());
        }
        return element;
     }

     T peek(){
         while (forward.size() >1){
             backward.push(forward.pop());
         }
         T element = forward.peek();
         while (backward.size() >0){
             forward.push(backward.pop());
         }
         return element;
     }

     int size(){
        return forward.size();
     }

     void display(){
         while (forward.size() >0){
             T elm = forward.pop();
             backward.push(elm);
         }
         while (backward.size() >0){
             T elm = backward.pop();
             System.out.print(elm + " ");
             forward.push(elm);
         }
         System.out.println();
     }
}
