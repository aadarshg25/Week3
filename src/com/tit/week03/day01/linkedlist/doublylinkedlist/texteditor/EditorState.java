package com.tit.week03.day01.linkedlist.doublylinkedlist.texteditor;

class EditorState {
    String textContent;
    EditorState prev;
    EditorState next;


    public EditorState(String textContent) {
        this.textContent = textContent;
        this.prev = null;
        this.next = null;
    }

    // Add a new state
    public static EditorState addState(EditorState current, String newText) {
        EditorState newState = new EditorState(newText);
        newState.prev = current;
        if (current != null) {
            current.next = newState;
        }
        newState.next = null; // Clear redo history
        return newState;
    }

    // Undo operation
    public static EditorState undo(EditorState current) {
        if (current == null || current.prev == null) {
            System.out.println("No more undo steps available.");
            return current;
        }
        return current.prev;
    }

    // Redo operation
    public static EditorState redo(EditorState current) {
        if (current == null || current.next == null) {
            System.out.println("No more redo steps available.");
            return current;
        }
        return current.next;
    }

    // Display current state
    public static void displayCurrentState(EditorState current) {
        if (current == null) {
            System.out.println("No text to display.");
        } else {
            System.out.println("Current Text: \"" + current.textContent + "\"");
        }
    }

    // Limit history size
    public static EditorState limitHistory(EditorState head, int maxSize) {
        int count = 0;
        EditorState temp = head;
        while (temp != null) {
            count++;
            if (count > maxSize) {
                head = head.next;
                head.prev = null;
            }
            temp = temp.next;
        }
        return head;
    }

    // Display all history
    public static void displayHistory(EditorState head) {
        if (head == null) {
            System.out.println("No history available.");
            return;
        }
        EditorState temp = head;
        System.out.print("Editor History: ");
        while (temp != null) {
            System.out.print("\"" + temp.textContent + "\" <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

