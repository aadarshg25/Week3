package com.tit.week03.day01.linkedlist.doublylinkedlist.librarymanagementsystem;

public class LibraryManagement {
    public static void main(String[] args) {
        BookNode head = null;
        BookNode tail = null;

        // Add books
        head = BookNode.addBook(head, tail, "Book A", "Author A", "Fiction", 1, true, -1);
        tail = head; // Initialize tail
        tail = BookNode.addBook(head, tail, "Book B", "Author B", "Non-Fiction", 2, true, -1);
        head = BookNode.addBook(head, tail, "Book C", "Author C", "Mystery", 3, false, 0);

        // Display books
        BookNode.displayForward(head);
        BookNode.displayReverse(tail);

        // Search for a book
        BookNode.searchBook(head, "Book A");

        // Update availability
        BookNode.updateAvailability(head, 2, false);

        // Remove a book
        head = BookNode.removeBook(head, tail, 3);

        // Count books
        BookNode.countBooks(head);

        // Display again
        BookNode.displayForward(head);
    }
}

