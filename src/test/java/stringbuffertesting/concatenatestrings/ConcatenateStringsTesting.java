package stringbuffertesting.concatenatestrings;

import static org.junit.jupiter.api.Assertions.*;

import com.tit.week03.day04.stringbuffer.concatenatestrings.ConcatenateStrings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConcatenateStringsTesting {

    ConcatenateStrings concatenateStrings;

    @BeforeEach
    void objectCreation() {
        concatenateStrings = new ConcatenateStrings();
    }

    @Test
    void testConcatenateStringsMultiple() {
        String[] input1 = {"Hello", "World", "!"};
        String expected1 = "HelloWorld!";
        String actual1 = concatenateStrings.concatenateStrings(input1);
        assertEquals(expected1, actual1);
    }


    @Test
    void testConcatenateStringsEmpty() {
        String[] input3 = {};
        String expected3 = "";
        String actual3 = concatenateStrings.concatenateStrings(input3);
        assertEquals(expected3, actual3, "The result should be an empty string for empty input.");
    }

}
