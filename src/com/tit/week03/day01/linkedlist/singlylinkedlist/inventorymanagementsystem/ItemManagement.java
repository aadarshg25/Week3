package com.tit.week03.day01.linkedlist.singlylinkedlist.inventorymanagementsystem;

public class ItemManagement {
    public static void main(String[] args) {
        ItemNode head = null;

        // Add items to the inventory
        head = ItemNode.addAtEnd(head, "Laptop", 101, 5, 1200.50);
        head = ItemNode.addAtBeginning(head, "Mouse", 102, 50, 15.75);
        head = ItemNode.addAtPosition(head, 1, "Keyboard", 103, 20, 45.99);

        // Display inventory
        System.out.println("Current Inventory:");
        ItemNode.displayInventory(head);

        // Update quantity
        ItemNode.updateQuantity(head, 102, 60);

        // Search items
        System.out.println("\nSearch for Item ID 101:");
        ItemNode.search(head, 101, "");

        System.out.println("\nSearch for Item Name 'Keyboard':");
        ItemNode.search(head, -1, "Keyboard");

        // Calculate total value
        System.out.println("\nCalculating total inventory value:");
        ItemNode.calculateTotalValue(head);

        // Sort by name in ascending order
        System.out.println("\nSorting inventory by Item Name (Ascending):");
        head = ItemNode.sortInventory(head, true, true);
        ItemNode.displayInventory(head);

        // Remove an item
        head = ItemNode.removeById(head, 102);

        // Display inventory after removal
        System.out.println("\nInventory after removing Item ID 102:");
        ItemNode.displayInventory(head);
    }
}

