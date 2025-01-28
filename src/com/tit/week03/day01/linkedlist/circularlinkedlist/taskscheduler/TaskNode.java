package com.tit.week03.day01.linkedlist.circularlinkedlist.taskscheduler;

class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;

    public TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }

    // add a task at the beginning
    public static TaskNode addAtBeginning(TaskNode head, int taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            newNode.next = newNode; // Circular reference
            return newNode;
        }
        TaskNode tail = getTail(head);
        newNode.next = head;
        tail.next = newNode;
        return newNode;
    }

    // add a task at the end
    public static TaskNode addAtEnd(TaskNode head, int taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            newNode.next = newNode; // Circular reference
            return newNode;
        }
        TaskNode tail = getTail(head);
        tail.next = newNode;
        newNode.next = head;
        return head;
    }

    // add a task at a specific position
    public static TaskNode addAtPosition(TaskNode head, int position, int taskId, String taskName, int priority, String dueDate) {
        if (position == 0) {
            return addAtBeginning(head, taskId, taskName, priority, dueDate);
        }
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        TaskNode temp = head;
        for (int i = 0; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }

    // Static method to remove a task by Task ID
    public static TaskNode removeById(TaskNode head, int taskId) {
        if (head == null) {
            System.out.println("List is empty.");
            return null;
        }
        TaskNode current = head, prev = null;
        do {
            if (current.taskId == taskId) {
                if (prev == null) { // Deleting the head
                    if (current.next == head) {
                        return null; // Only one node in the list
                    }
                    TaskNode tail = getTail(head);
                    tail.next = current.next;
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
                System.out.println("Task with ID " + taskId + " removed.");
                return head;
            }
            prev = current;
            current = current.next;
        } while (current != head);
        System.out.println("Task with ID " + taskId + " not found.");
        return head;
    }

    // Static method to view the current task and move to the next task
    public static TaskNode viewCurrentAndNext(TaskNode current) {
        if (current == null) {
            System.out.println("No tasks to view.");
            return null;
        }
        System.out.println("Current Task: { Task ID: " + current.taskId + ", Task Name: " + current.taskName +
                ", Priority: " + current.priority + ", Due Date: " + current.dueDate + " }");
        return current.next;
    }

    // Static method to display all tasks
    public static void displayAllTasks(TaskNode head) {
        if (head == null) {
            System.out.println("No records to display.");
            return;
        }
        TaskNode temp = head;
        do {
            System.out.print(" { Task ID: " + temp.taskId + ", Task Name: " + temp.taskName +
                    ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate + " } -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }

    // Static method to search for tasks by priority
    public static void searchByPriority(TaskNode head, int priority) {
        if (head == null) {
            System.out.println("No tasks to search.");
            return;
        }
        boolean found = false;
        TaskNode temp = head;
        do {
            if (temp.priority == priority) {
                System.out.println("Found: { Task ID: " + temp.taskId + ", Task Name: " + temp.taskName +
                        ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate + " }");
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) {
            System.out.println("No tasks found with priority " + priority);
        }
    }

    // Helper method to get the tail node
    private static TaskNode getTail(TaskNode head) {
        TaskNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        return temp;
    }
}

