package com.tit.week03.day01.linkedlist.circularlinkedlist.roundrobinschedulingalgorithm;

class RoundRobin {
    public static void main(String[] args) {
        ProcessNode head = null;

        // Add processes
        head = ProcessNode.addProcess(head, 1, 10, 3);
        head = ProcessNode.addProcess(head, 2, 5, 2);
        head = ProcessNode.addProcess(head, 3, 8, 1);

        // Display processes
        System.out.println("Processes in Circular Queue:");
        ProcessNode.displayProcesses(head);

        // Simulate round-robin scheduling
        int timeQuantum = 4;
        ProcessNode.simulateRoundRobin(head, timeQuantum);

        // Remove a process and display again
        head = ProcessNode.removeProcess(head, 2);
        System.out.println("\nProcesses after removing Process ID 2:");
        ProcessNode.displayProcesses(head);
    }
}

