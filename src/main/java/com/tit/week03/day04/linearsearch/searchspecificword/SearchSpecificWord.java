package com.tit.week03.day04.linearsearch.searchspecificword;

public class SearchSpecificWord {
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
                "Hello World",
                "Java is a popular programming language.",
                "Linear search is a simple searching algorithm."
        };

        String wordToFind = "Java";
        String result = findSentenceWithWord(sentences, wordToFind);

        System.out.println("Sentence found: " + result);
    }
}
