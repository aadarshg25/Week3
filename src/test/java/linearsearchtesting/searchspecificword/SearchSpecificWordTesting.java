package linearsearchtesting.searchspecificword;

import static org.junit.jupiter.api.Assertions.*;

import com.tit.week03.day04.linearsearch.searchspecificword.SearchSpecificWord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SearchSpecificWordTesting {
    SearchSpecificWord searchSpecificWord;

    @BeforeEach
    void objectCreation() {
        searchSpecificWord = new SearchSpecificWord();
    }

    @Test
    void testFindSentenceWithWord() {
        String[] sentences = {
                "Hello World",
                "Java is a popular programming language.",
                "Linear search is a simple searching algorithm."
        };
        assertEquals("Java is a popular programming language.", searchSpecificWord.findSentenceWithWord(sentences, "Java"));
    }

    @Test
    void testWordNotFound() {
        String[] sentences = {
                "Hello World",
                "Java is a popular programming language.",
                "Linear search is a simple searching algorithm."
        };
        assertEquals("Not Found", searchSpecificWord.findSentenceWithWord(sentences, "Python"));
    }

    @Test
    void testEmptySentences() {
        String[] sentences = {};
        assertEquals("Not Found", searchSpecificWord.findSentenceWithWord(sentences, "Java"));
    }
}
