package stringbuildertesting.reversestring;

import com.tit.week03.day04.stringbuilder.reversestring.ReverseString;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReverseStringTesting {
    ReverseString reverseString;
    @BeforeEach
    void objectCreation(){
        reverseString = new ReverseString();
    }

    @Test
    void testReversalWithNormalString() {
        assertEquals("olleH", reverseString.reverse("Hello"));
    }

    @Test
    void testReversalWithSpaces() {
        assertEquals("avaJ si nuf", reverseString.reverse("fun is Java"));
    }

    @Test
    void testReversalWithSpecialCharacters() {
        assertEquals("!dlroW ,olleH", reverseString.reverse("Hello, World!"));
    }

}
