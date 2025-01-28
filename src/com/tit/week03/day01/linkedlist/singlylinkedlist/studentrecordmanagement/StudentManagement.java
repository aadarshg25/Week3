package com.tit.week03.day01.linkedlist.singlylinkedlist.studentrecordmanagement;

public class StudentManagement {
    public static void main(String[] args) {
        StudentNode head = null;

        // Adding students
        head = StudentNode.addAtBeginning(head, 101, "Alice", 20, "A");
        head = StudentNode.addAtEnd(head, 102, "Brook", 21, "B");
        head = StudentNode.addAtPosition(head, 1, 103, "Jesica", 22, "C");

        // Display all records
        StudentNode.displayAll(head);

        // Search for a student
        StudentNode.searchByRollNumber(head, 102);

        // Update a student's grade
        StudentNode.updateGrade(head, 103, "A+");

        // Delete a student
        head = StudentNode.deleteByRollNumber(head, 101);

        // Display all records again
        StudentNode.displayAll(head);
    }
}

