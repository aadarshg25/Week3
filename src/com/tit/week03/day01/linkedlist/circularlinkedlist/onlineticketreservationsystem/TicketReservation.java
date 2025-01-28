package com.tit.week03.day01.linkedlist.circularlinkedlist.onlineticketreservationsystem;

public class TicketReservation {
    public static void main(String[] args) {
        TicketNode head = null;

        // Add tickets
        head = TicketNode.addTicket(head, 101, "Alice", "Inception", "A1", "10:00 AM");
        head = TicketNode.addTicket(head, 102, "Brook", "Titanic", "B2", "1:00 PM");
        head = TicketNode.addTicket(head, 103, "Janise", "Avatar", "C3", "4:00 PM");

        // Display tickets
        TicketNode.displayTickets(head);

        // Remove a ticket
        head = TicketNode.removeTicket(head, 102);
        TicketNode.displayTickets(head);

        // Search for a ticket
        TicketNode.searchTicket(head, "Avatar");
        TicketNode.searchTicket(head, "John");

        // Count tickets
        int totalTickets = TicketNode.countTickets(head);
        System.out.println("Total Tickets Booked: " + totalTickets);
    }
}
