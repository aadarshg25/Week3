package com.tit.week03.day01.linkedlist.circularlinkedlist.taskscheduler;

public class TaskManagement {
    public static void main(String[] args) {
        TaskNode head = null;
        TaskNode currentTask = null;

        // Adding tasks
        head = TaskNode.addAtEnd(head, 1, "Task A", 1, "2025-02-01");
        head = TaskNode.addAtBeginning(head, 2, "Task B", 2, "2025-01-30");
        head = TaskNode.addAtPosition(head, 1, 3, "Task C", 1, "2025-01-31");

        // Display tasks
        System.out.println("All tasks:");
        TaskNode.displayAllTasks(head);

        // View current task and move to next
        currentTask = head;
        currentTask = TaskNode.viewCurrentAndNext(currentTask);
        currentTask = TaskNode.viewCurrentAndNext(currentTask);

        // Search for a task by priority
        System.out.println("\nSearch tasks with priority 1:");
        TaskNode.searchByPriority(head, 1);

        // Remove a task
        head = TaskNode.removeById(head, 2);

        // Display tasks after removal
        System.out.println("\nAll tasks after removal:");
        TaskNode.displayAllTasks(head);
    }
}

