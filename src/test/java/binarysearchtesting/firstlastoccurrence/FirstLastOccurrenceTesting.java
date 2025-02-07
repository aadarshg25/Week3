package binarysearchtesting.firstlastoccurrence;
import static org.junit.jupiter.api.Assertions.*;
import com.tit.week03.day04.binarysearch.firstlastoccurrence.FirstLastOccurrence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FirstLastOccurrenceTesting {
    FirstLastOccurrence firstLastOccurrence;

    @BeforeEach
    void objectCreation() {
        firstLastOccurrence = new FirstLastOccurrence();
    }

    @Test
    void testFindFirstOccurrence() {
        int[] arr = {1, 2, 2, 3, 4, 4, 4, 5, 6};
        assertEquals(4, firstLastOccurrence.findFirstOccurrence(arr, 4));
    }

    @Test
    void testFindLastOccurrence() {
        int[] arr = {1, 2, 2, 3, 4, 4, 4, 5, 6};
        assertEquals(6, firstLastOccurrence.findLastOccurrence(arr, 4));
    }

    @Test
    void testFindFirstAndLastOccurrence() {
        int[] arr = {1, 2, 2, 3, 4, 4, 4, 5, 6};
        int[] expected = {4, 6};
        assertArrayEquals(expected, firstLastOccurrence.findFirstAndLastOccurrence(arr, 4));
    }
}

