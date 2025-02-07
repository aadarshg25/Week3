package stringbuildertesting.removeduplicates;


import static org.junit.jupiter.api.Assertions.*;

import com.tit.week03.day04.stringbuilder.removeduplicates.RemoveDuplicates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RemoveDuplicatesTesting {
    RemoveDuplicates removeDuplicates;

    @BeforeEach
    void objectCreation() {
        removeDuplicates = new RemoveDuplicates();
    }

    @Test
    void testRemoveDuplicatesNormalString() {
        assertEquals("helo", removeDuplicates.removeDuplicates("hello"));
    }

    @Test
    void testRemoveDuplicatesWithSpaces() {
        assertEquals("helo wrd", removeDuplicates.removeDuplicates("hello world"));
    }

    @Test
    void testRemoveDuplicatesWithSpecialCharacters() {
        assertEquals("h!el o", removeDuplicates.removeDuplicates("h!h!eell  oo"));
    }


}

