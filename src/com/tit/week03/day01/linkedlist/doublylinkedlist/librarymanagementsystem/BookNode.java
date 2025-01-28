package com.tit.week03.day01.linkedlist.doublylinkedlist.librarymanagementsystem;

class BookNode {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    BookNode next;
    BookNode prev;

    public BookNode(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }

    // Add a new book
    public static BookNode addBook(BookNode head, BookNode tail, String title, String author, String genre, int bookId, boolean isAvailable, int position) {
        BookNode newBook = new BookNode(title, author, genre, bookId, isAvailable);

        if (position == 0) { // Add at the beginning
            if (head == null) {
                return newBook; // First book
            } else {
                newBook.next = head;
                head.prev = newBook;
                return newBook; // Update head
            }
        } else if (position == -1) { // Add at the end
            if (tail == null) {
                return newBook; // First book
            } else {
                tail.next = newBook;
                newBook.prev = tail;
                return newBook; // Update tail
            }
        } else { // Add at a specific position
            BookNode temp = head;
            int count = 0;

            while (temp != null && count < position - 1) {
                temp = temp.next;
                count++;
            }

            if (temp == null) {
                System.out.println("Position out of bounds.");
                return head;
            }

            newBook.next = temp.next;
            if (temp.next != null) {
                temp.next.prev = newBook;
            }
            temp.next = newBook;
            newBook.prev = temp;

            return head;
        }
    }

    // Remove a book by Book ID
    public static BookNode removeBook(BookNode head, BookNode tail, int bookId) {
        if (head == null) {
            System.out.println("No books in the library.");
            return head;
        }

        BookNode temp = head;

        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Book with ID " + bookId + " not found.");
            return head;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next; // Update head if the first node is removed
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        } else {
            tail = temp.prev; // Update tail if the last node is removed
        }

        System.out.println("Book with ID " + bookId + " has been removed.");
        return head;
    }

    // Search for a book by Title or Author
    public static void searchBook(BookNode head, String titleOrAuthor) {
        if (head == null) {
            System.out.println("No books in the library.");
            return;
        }

        BookNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(titleOrAuthor) || temp.author.equalsIgnoreCase(titleOrAuthor)) {
                System.out.println("Found Book: { Title: " + temp.title + ", Author: " + temp.author +
                        ", Genre: " + temp.genre + ", Book ID: " + temp.bookId +
                        ", Available: " + temp.isAvailable + " }");
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No book found with Title or Author: " + titleOrAuthor);
        }
    }

    // Update a book's Availability Status
    public static void updateAvailability(BookNode head, int bookId, boolean newStatus) {
        if (head == null) {
            System.out.println("No books in the library.");
            return;
        }

        BookNode temp = head;

        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Book with ID " + bookId + " not found.");
            return;
        }

        temp.isAvailable = newStatus;
        System.out.println("Updated Availability for Book ID " + bookId + " to " + newStatus);
    }

    // Count total number of books in the library
    public static void countBooks(BookNode head) {
        int count = 0;
        BookNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("Total number of books in the library: " + count);
    }

    // Display all books in forward order
    public static void displayForward(BookNode head) {
        if (head == null) {
            System.out.println("No books in the library.");
            return;
        }
        BookNode temp = head;
        while (temp != null) {
            System.out.print(" { Title: " + temp.title + ", Author: " + temp.author +
                    ", Genre: " + temp.genre + ", Book ID: " + temp.bookId +
                    ", Available: " + temp.isAvailable + " } -> ");
            temp = temp.next;
        }
        System.out.println(" null");
    }

    // Display all books in reverse order
    public static void displayReverse(BookNode tail) {
        if (tail == null) {
            System.out.println("No books in the library.");
            return;
        }
        System.out.print("null ");
        BookNode temp = tail;
        while (temp != null) {
            System.out.print(" <- { Title: " + temp.title + ", Author: " + temp.author +
                    ", Genre: " + temp.genre + ", Book ID: " + temp.bookId +
                    ", Available: " + temp.isAvailable + " } ");
            temp = temp.prev;
        }
        System.out.println();
    }
}

