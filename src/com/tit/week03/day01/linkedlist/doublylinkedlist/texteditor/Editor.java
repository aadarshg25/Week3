package com.tit.week03.day01.linkedlist.doublylinkedlist.texteditor;

public class Editor {
    public static void main(String[] args) {
        // Initialize editor
        EditorState head = null;
        EditorState current = null;

        // Adding text states
        current = EditorState.addState(current, "Hello");
        if (head == null) head = current; // Set head for the first state
        current = EditorState.addState(current, "Hello World");
        current = EditorState.addState(current, "Hello World!");

        // Display current state
        EditorState.displayCurrentState(current);

        // Undo operations
        current = EditorState.undo(current);
        EditorState.displayCurrentState(current);

        current = EditorState.undo(current);
        EditorState.displayCurrentState(current);

        // Redo operation
        current = EditorState.redo(current);
        EditorState.displayCurrentState(current);

        // Limit history to the last 2 states
        head = EditorState.limitHistory(head, 2);
        EditorState.displayHistory(head);
    }
}
