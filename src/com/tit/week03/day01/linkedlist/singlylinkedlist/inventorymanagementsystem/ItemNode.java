package com.tit.week03.day01.linkedlist.singlylinkedlist.inventorymanagementsystem;

class ItemNode {
    String itemName;
    int itemId;
    int quantity;
    double price;
    ItemNode next;

    public ItemNode(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }

    // add an item at the beginning
    public static ItemNode addAtBeginning(ItemNode head, String itemName, int itemId, int quantity, double price) {
        ItemNode newNode = new ItemNode(itemName, itemId, quantity, price);
        newNode.next = head;
        return newNode;
    }

    // add an item at the end
    public static ItemNode addAtEnd(ItemNode head, String itemName, int itemId, int quantity, double price) {
        ItemNode newNode = new ItemNode(itemName, itemId, quantity, price);
        if (head == null) {
            return newNode;
        }
        ItemNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    // add an item at a specific position
    public static ItemNode addAtPosition(ItemNode head, int position, String itemName, int itemId, int quantity, double price) {
        if (position == 0) {
            return addAtBeginning(head, itemName, itemId, quantity, price);
        }
        ItemNode newNode = new ItemNode(itemName, itemId, quantity, price);
        ItemNode temp = head;
        for (int i = 0; i < position - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }

    // remove an item by Item ID
    public static ItemNode removeById(ItemNode head, int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return null;
        }
        if (head.itemId == itemId) {
            System.out.println("Item with ID " + itemId + " removed.");
            return head.next;
        }
        ItemNode temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Item with ID " + itemId + " not found.");
        } else {
            System.out.println("Item with ID " + itemId + " removed.");
            temp.next = temp.next.next;
        }
        return head;
    }

    // update the quantity of an item by Item ID
    public static void updateQuantity(ItemNode head, int itemId, int newQuantity) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated for Item ID " + itemId);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    // search for an item by Item ID or Item Name
    public static void search(ItemNode head, int itemId, String itemName) {
        ItemNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.itemId == itemId || temp.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Found: { Item Name: " + temp.itemName + ", Item ID: " + temp.itemId +
                        ", Quantity: " + temp.quantity + ", Price: " + temp.price + " }");
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No item found with the given criteria.");
        }
    }

    // calculate the total value of the inventory
    public static void calculateTotalValue(ItemNode head) {
        double totalValue = 0;
        ItemNode temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: $" + totalValue);
    }

    // sort the inventory by Item Name or Price
    public static ItemNode sortInventory(ItemNode head, boolean byName, boolean ascending) {
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Split the linked list into two halves
        ItemNode middle = getMiddle(head);
        ItemNode nextOfMiddle = middle.next;
        middle.next = null;

        // Step 2: Recursively sort the two halves
        ItemNode left = sortInventory(head, byName, ascending);
        ItemNode right = sortInventory(nextOfMiddle, byName, ascending);

        // Step 3: Merge the sorted halves
        return mergeSortedLists(left, right, byName, ascending);
    }

    // Helper method to find the middle of the linked list
    private static ItemNode getMiddle(ItemNode head) {
        if (head == null) {
            return null;
        }
        ItemNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Helper method to merge two sorted linked lists
    private static ItemNode mergeSortedLists(ItemNode left, ItemNode right, boolean byName, boolean ascending) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        ItemNode result;

        // Compare based on sorting criteria
        if (byName) {
            if (ascending) {
                if (left.itemName.compareToIgnoreCase(right.itemName) <= 0) {
                    result = left;
                    result.next = mergeSortedLists(left.next, right, byName, ascending);
                } else {
                    result = right;
                    result.next = mergeSortedLists(left, right.next, byName, ascending);
                }
            } else {
                if (left.itemName.compareToIgnoreCase(right.itemName) > 0) {
                    result = left;
                    result.next = mergeSortedLists(left.next, right, byName, ascending);
                } else {
                    result = right;
                    result.next = mergeSortedLists(left, right.next, byName, ascending);
                }
            }
        } else {
            if (ascending) {
                if (left.price <= right.price) {
                    result = left;
                    result.next = mergeSortedLists(left.next, right, byName, ascending);
                } else {
                    result = right;
                    result.next = mergeSortedLists(left, right.next, byName, ascending);
                }
            } else {
                if (left.price > right.price) {
                    result = left;
                    result.next = mergeSortedLists(left.next, right, byName, ascending);
                } else {
                    result = right;
                    result.next = mergeSortedLists(left, right.next, byName, ascending);
                }
            }
        }

        return result;
    }


    // display all items
    public static void displayInventory(ItemNode head) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        ItemNode temp = head;
        while (temp != null) {
            System.out.print(" { Item Name: " + temp.itemName + ", Item ID: " + temp.itemId +
                    ", Quantity: " + temp.quantity + ", Price: $" + temp.price + " } -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

