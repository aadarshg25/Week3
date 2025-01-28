package com.tit.week03.day01.linkedlist.doublylinkedlist.moviemanagementsystem;

public class MovieManagement {
    public static void main(String[] args) {
        MovieNode head = null;
        MovieNode tail = null;

        // Adding movies
        head = MovieNode.addAtBeginning(head, "Inception", "Christopher Nolan", 2010, 8.8);
        tail = head;
        head = MovieNode.addAtEnd(head, tail, "The Godfather", "Francis Ford Coppola", 1972, 9.2);
        tail = tail.next;
        head = MovieNode.addAtPosition(head, 1, "Prestige", "Quentin Tarantino", 1994, 8.9);

        // Display movies
        System.out.println("Movies in forward order:");
        MovieNode.displayForward(head);

        System.out.println("\nMovies in reverse order:");
        MovieNode.displayReverse(tail);

        // Search for a movie
        System.out.println("\nSearch for movies by director or rating:");
        MovieNode.searchByDirectorOrRating(head, "Quentin Tarantino", 9.2);

        // Update a movie's rating
        MovieNode.updateRating(head, "Inception", 9.0);

        // Remove a movie
        head = MovieNode.removeByTitle(head, "The Godfather");

        // Display movies again
        System.out.println("\nMovies after updates:");
        MovieNode.displayForward(head);
    }
}

