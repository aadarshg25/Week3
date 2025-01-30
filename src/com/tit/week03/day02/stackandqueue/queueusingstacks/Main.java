package com.tit.week03.day02.stackandqueue.queueusingstacks;

 class Main {
     public static void main(String[] args) {
         QueueImplemented<Integer> queue = new QueueImplemented<>();
         queue.enqueue(10);
         queue.enqueue(20);
         queue.enqueue(30);
         queue.enqueue(40);
         queue.enqueue(50);

         queue.display();

         System.out.println(queue.peek());

         queue.dequeue();
         queue.dequeue();
         queue.dequeue();

         System.out.println(queue.peek());
         queue.display();

         queue.enqueue(70);
         queue.enqueue(80);

         queue.display();
     }
}
