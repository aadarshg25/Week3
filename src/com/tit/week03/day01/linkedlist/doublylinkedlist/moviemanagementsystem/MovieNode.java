package com.tit.week03.day01.linkedlist.doublylinkedlist.moviemanagementsystem;

class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    MovieNode next;
    MovieNode prev;

    public MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }

    // add a movie at the beginning
    public static MovieNode addAtBeginning(MovieNode head, String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        return newNode;
    }

    // add a movie at the end
    public static MovieNode addAtEnd(MovieNode head, MovieNode tail, String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            return newNode; // Return the new head if the list is empty
        }
        tail.next = newNode;
        newNode.prev = tail;
        return head;
    }

    // add a movie at a specific position
    public static MovieNode addAtPosition(MovieNode head, int position, String title, String director, int year, double rating) {
        if (position == 0) {
            return addAtBeginning(head, title, director, year, rating);
        }
        MovieNode newNode = new MovieNode(title, director, year, rating);
        MovieNode temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds.");
            return head;
        }
        newNode.next = temp.next;
        newNode.prev = temp;
        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;
        return head;
    }

    // remove a movie by title
    public static MovieNode removeByTitle(MovieNode head, String title) {
        if (head == null) {
            System.out.println("List is empty.");
            return null;
        }
        MovieNode temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Movie with title \"" + title + "\" not found.");
            return head;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next; // Update head if the first node is deleted
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        return head;
    }

    // Static method to search movies by director or rating
    public static void searchByDirectorOrRating(MovieNode head, String director, double rating) {
        boolean found = false;
        MovieNode temp = head;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director) || temp.rating == rating) {
                System.out.println("Found: Title: " + temp.title + ", Director: " + temp.director +
                        ", Year: " + temp.year + ", Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No movies found matching the criteria.");
        }
    }

    // Static method to display all movies in forward order
    public static void displayForward(MovieNode head) {
        if (head == null) {
            System.out.println("No records to display.");
            return;
        }
        MovieNode temp = head;
        while (temp != null) {
            System.out.print(" { Title: " + temp.title + ", Director: " + temp.director +
                    ", Year: " + temp.year + ", Rating: " + temp.rating+ " } -> ");
            temp = temp.next;
        }
        System.out.println(" null");
    }

    // Static method to display all movies in reverse order
    public static void displayReverse(MovieNode tail) {
        if (tail == null) {
            System.out.println("No records to display.");
            return;
        }
        System.out.print("null ");
        MovieNode temp = tail;
        while (temp != null) {
            System.out.print(" <- { Title: " + temp.title + ", Director: " + temp.director +
                    ", Year: " + temp.year + ", Rating: " + temp.rating + " } ");
            temp = temp.prev;
        }
    }

    // Static method to update a movie's rating by title
    public static void updateRating(MovieNode head, String title, double newRating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Updated rating for \"" + title + "\" to " + newRating);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie with title \"" + title + "\" not found.");
    }
}

