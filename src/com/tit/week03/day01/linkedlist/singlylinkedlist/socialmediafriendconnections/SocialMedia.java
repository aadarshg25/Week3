package com.tit.week03.day01.linkedlist.singlylinkedlist.socialmediafriendconnections;

class SocialMedia {
    public static void main(String[] args) {
        UserNode head = new UserNode(1, "Alice", 25);
        head.next = new UserNode(2, "Brook", 30);
        head.next.next = new UserNode(3, "Jesica", 22);
        head.next.next.next = new UserNode(4, "Rio", 27);

        // Add friends
        UserNode.addFriend(head, 1, 2);
        UserNode.addFriend(head, 1, 3);
        UserNode.addFriend(head, 2, 4);

        // Display all users
        System.out.println("All users:");
        UserNode.displayAllUsers(head);

        // Display friends of Alice
        System.out.println("\nFriends of Alice:");
        UserNode.displayFriends(head, 1);

        // Find mutual friends between Alice and Bob
        System.out.println("\nMutual friends between Alice and Brook:");
        UserNode.findMutualFriends(head, 1, 2);

        // Remove a friend connection
        System.out.println("\nRemoving friendship between Alice and Brook...");
        UserNode.removeFriend(head, 1, 2);

        // Display friends of Alice after removal
        System.out.println("\nFriends of Alice after removal:");
        UserNode.displayFriends(head, 1);

        // Count the number of friends for each user
        System.out.println("\nFriend counts:");
        UserNode.countFriends(head);
    }
}
