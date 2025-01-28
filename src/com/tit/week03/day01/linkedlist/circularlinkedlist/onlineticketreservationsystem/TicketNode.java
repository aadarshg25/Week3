package com.tit.week03.day01.linkedlist.circularlinkedlist.onlineticketreservationsystem;

class TicketNode {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    TicketNode next;

    // Constructor
    public TicketNode(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }

    // Add a new ticket reservation at the end
    public static TicketNode addTicket(TicketNode head, int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        TicketNode newNode = new TicketNode(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            newNode.next = newNode; // Point to itself in a circular manner
            return newNode;
        }
        TicketNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = head; // Maintain circular nature
        return head;
    }

    // Remove a ticket by Ticket ID
    public static TicketNode removeTicket(TicketNode head, int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return null;
        }
        TicketNode current = head, prev = null;
        do {
            if (current.ticketId == ticketId) {
                if (prev == null) { // Removing the head node
                    TicketNode temp = head;
                    while (temp.next != head) {
                        temp = temp.next;
                    }
                    if (temp == head) { // Only one ticket in the list
                        return null;
                    }
                    temp.next = head.next;
                    head = head.next;
                } else {
                    prev.next = current.next;
                }
                System.out.println("Ticket with ID " + ticketId + " has been removed.");
                return head;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        System.out.println("Ticket with ID " + ticketId + " not found.");
        return head;
    }

    // Display all tickets
    public static void displayTickets(TicketNode head) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        TicketNode temp = head;
        System.out.println("Current Tickets:");
        do {
            System.out.print("{ Ticket ID: " + temp.ticketId + ", Customer Name: " + temp.customerName +
                    ", Movie Name: " + temp.movieName + ", Seat Number: " + temp.seatNumber +
                    ", Booking Time: " + temp.bookingTime + " } ->");
            temp = temp.next;
        } while (temp != head);
        System.out.println(" null");
    }

    // Search for a ticket by Customer Name or Movie Name
    public static void searchTicket(TicketNode head, String searchKey) {
        if (head == null) {
            System.out.println("No tickets to search.");
            return;
        }
        TicketNode temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(searchKey) || temp.movieName.equalsIgnoreCase(searchKey)) {
                System.out.println("Found Ticket: { Ticket ID: " + temp.ticketId + ", Customer Name: " + temp.customerName +
                        ", Movie Name: " + temp.movieName + ", Seat Number: " + temp.seatNumber +
                        ", Booking Time: " + temp.bookingTime + " }");
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tickets found for search key: " + searchKey);
        }
    }

    // Calculate the total number of booked tickets
    public static int countTickets(TicketNode head) {
        if (head == null) {
            return 0;
        }
        int count = 0;
        TicketNode temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }
}
