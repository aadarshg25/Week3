package com.tit.week03.day01.linkedlist.circularlinkedlist.roundrobinschedulingalgorithm;

class ProcessNode {
    int processId;
    int burstTime;
    int priority;
    ProcessNode next;

    // Constructor
    public ProcessNode(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }

    // Add a new process at the end
    public static ProcessNode addProcess(ProcessNode head, int processId, int burstTime, int priority) {
        ProcessNode newProcess = new ProcessNode(processId, burstTime, priority);
        if (head == null) {
            newProcess.next = newProcess; // Circular link
            return newProcess; // Head is the only process
        }

        ProcessNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newProcess;
        newProcess.next = head; // Maintain circular nature
        return head;
    }

    // Remove a process by Process ID
    public static ProcessNode removeProcess(ProcessNode head, int processId) {
        if (head == null) {
            System.out.println("No processes to remove.");
            return null;
        }

        ProcessNode temp = head, prev = null;

        // Special case: removing the head process
        if (head.processId == processId) {
            if (head.next == head) {
                return null; // Only one process in the list
            }
            // Update head and remove circular reference
            ProcessNode tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            tail.next = head.next;
            head = head.next;
            return head;
        }

        // Traverse to find and remove the process
        do {
            prev = temp;
            temp = temp.next;

            if (temp.processId == processId) {
                prev.next = temp.next;
                return head;
            }
        } while (temp != head);

        System.out.println("Process with ID " + processId + " not found.");
        return head;
    }

    // Simulate round-robin scheduling
    public static void simulateRoundRobin(ProcessNode head, int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        ProcessNode temp = head;
        int totalProcesses = 0, totalWaitingTime = 0, totalTurnaroundTime = 0;

        // Count the total number of processes
        ProcessNode countNode = head;
        do {
            totalProcesses++;
            countNode = countNode.next;
        } while (countNode != head);

        System.out.println("Starting Round Robin Scheduling with Time Quantum = " + timeQuantum);

        // Execute processes in round-robin order
        while (true) {
            boolean allCompleted = true;
            temp = head;

            do {
                if (temp.burstTime > 0) {
                    allCompleted = false;

                    System.out.println("Executing Process ID: " + temp.processId +
                            ", Burst Time Left: " + temp.burstTime);

                    if (temp.burstTime <= timeQuantum) {
                        totalTurnaroundTime += temp.burstTime;
                        totalWaitingTime += (totalTurnaroundTime - temp.burstTime);
                        temp.burstTime = 0;
                        System.out.println("Process ID " + temp.processId + " has completed execution.");
                    } else {
                        temp.burstTime -= timeQuantum;
                        totalTurnaroundTime += timeQuantum;
                    }
                }
                temp = temp.next;

            } while (temp != head);

            if (allCompleted) break; // Exit if all processes are complete
        }

        // Display average waiting time and turnaround time
        double avgWaitingTime = (double) totalWaitingTime / totalProcesses;
        double avgTurnaroundTime = (double) totalTurnaroundTime / totalProcesses;

        System.out.println("Average Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
    }

    // Display all processes in the circular queue
    public static void displayProcesses(ProcessNode head) {
        if (head == null) {
            System.out.println("No processes to display.");
            return;
        }

        ProcessNode temp = head;
        do {
            System.out.print(" { Process ID: " + temp.processId +
                    ", Burst Time: " + temp.burstTime +
                    ", Priority: " + temp.priority + " } -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(Back to Head)");
    }
}

