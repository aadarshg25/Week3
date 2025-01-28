package com.tit.week03.day01.linkedlist.singlylinkedlist.socialmediafriendconnections;

import java.util.ArrayList;
import java.util.List;

class UserNode {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;
    UserNode next;

    public UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }

    // add a friend connection
    public static void addFriend(UserNode head, int userId1, int userId2) {
        UserNode user1 = findUser(head, userId1);
        UserNode user2 = findUser(head, userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        if (!user1.friendIds.contains(userId2)) {
            user1.friendIds.add(userId2);
        }
        if (!user2.friendIds.contains(userId1)) {
            user2.friendIds.add(userId1);
        }
    }

    // remove a friend connection
    public static void removeFriend(UserNode head, int userId1, int userId2) {
        UserNode user1 = findUser(head, userId1);
        UserNode user2 = findUser(head, userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        //Conversion due to remove(Object o)
        user1.friendIds.remove(Integer.valueOf(userId2));
        user2.friendIds.remove(Integer.valueOf(userId1));
    }

    // find mutual friends
    public static void findMutualFriends(UserNode head, int userId1, int userId2) {
        UserNode user1 = findUser(head, userId1);
        UserNode user2 = findUser(head, userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        if (user1.friendIds.isEmpty() || user2.friendIds.isEmpty()) {
            System.out.println("One or both users have no friends.");
            return;
        }

        // Find mutual friends
        boolean mutualFound = false;
        StringBuilder mutualFriends = new StringBuilder();

        for (int friendId : user1.friendIds) {
            if (user2.friendIds.contains(friendId)) {
                if (!mutualFound) {
                    // Print this only if at least one mutual friend is found
                    System.out.println("Mutual Friends between " + user1.name + " and " + user2.name + ":");
                    mutualFound = true;
                }
                mutualFriends.append("User ID: ").append(friendId).append("\n");
            }
        }

        if (mutualFound) {
            System.out.print(mutualFriends.toString());
        } else {
            System.out.println("No mutual friends found between " + user1.name + " and " + user2.name + ".");
        }
    }


    // display all friends of a specific user
    public static void displayFriends(UserNode head, int userId) {
        UserNode user = findUser(head, userId);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Friends of " + user.name + ":");
        for (int friendId : user.friendIds) {
            System.out.println("User ID: " + friendId);
        }
    }

    // search for a user by Name or User ID
    public static UserNode findUser(UserNode head, int userId) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public static UserNode searchUserByName(UserNode head, String name) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // count the number of friends for each user
    public static void countFriends(UserNode head) {
        UserNode temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIds.size() + " friend(s).");
            temp = temp.next;
        }
    }

    // Static method to display all users
    public static void displayAllUsers(UserNode head) {
        if (head == null) {
            System.out.println("No users to display.");
            return;
        }

        UserNode temp = head;
        while (temp != null) {
            System.out.print("{ User ID: " + temp.userId + ", Name: " + temp.name +
                    ", Age: " + temp.age + ", Friends: " + temp.friendIds + " } -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

