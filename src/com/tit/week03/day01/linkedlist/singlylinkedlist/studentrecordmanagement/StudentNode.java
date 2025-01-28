package com.tit.week03.day01.linkedlist.singlylinkedlist.studentrecordmanagement;

class StudentNode {
    int rollNumber;
    String name;
    int age;
    String grade;
    StudentNode next;


    public StudentNode(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }

    // add at the beginning
    public static StudentNode addAtBeginning(StudentNode head, int rollNumber, String name, int age, String grade) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        newNode.next = head;
        return newNode;
    }

    // add at the end
    public static StudentNode addAtEnd(StudentNode head, int rollNumber, String name, int age, String grade) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        if (head == null) {
            return newNode;
        }
        StudentNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    // add at a specific position
    public static StudentNode addAtPosition(StudentNode head, int position, int rollNumber, String name, int age, String grade) {
        if (position == 0) { //Conserding 0-Based Indexing
            return addAtBeginning(head, rollNumber, name, age, grade);
        }
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        StudentNode temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds.");
            return head;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }

    // delete by roll number
    public static StudentNode deleteByRollNumber(StudentNode head, int rollNumber) {
        if (head == null) {
            System.out.println("List is empty.");
            return null;
        }
        if (head.rollNumber == rollNumber) {
            return head.next;
        }
        StudentNode temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
            return head;
        }
        temp.next = temp.next.next;
        return head;
    }

    // search by roll number
    public static void searchByRollNumber(StudentNode head, int rollNumber) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                System.out.println("Found: Roll Number: " + temp.rollNumber + ", Name: " + temp.name +
                        ", Age: " + temp.age + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }

    // update grade by roll number
    public static void updateGrade(StudentNode head, int rollNumber, String newGrade) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                temp.grade = newGrade;
                System.out.println("Updated grade for Roll Number " + rollNumber + " to " + newGrade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }

    // display all students
    public static void displayAll(StudentNode head) {
        if (head == null) {
            System.out.println("No records to display.");
            return;
        }
        StudentNode temp = head;
        while (temp != null) {
            System.out.print(" { Roll Number: " + temp.rollNumber + ", Name: " + temp.name +
                    ", Age: " + temp.age + ", Grade: " + temp.grade + " } ->");
            temp = temp.next;
        }
        System.out.println(" null");
    }
}
