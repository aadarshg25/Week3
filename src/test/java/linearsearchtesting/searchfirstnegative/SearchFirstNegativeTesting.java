package linearsearchtesting.searchfirstnegative;

import static org.junit.jupiter.api.Assertions.*;

import com.tit.week03.day04.linearsearch.searchfirstnegative.SearchFirstNegative;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SearchFirstNegativeTesting {
    SearchFirstNegative searchFirstNegative;

    @BeforeEach
    void objectCreation() {
        searchFirstNegative = new SearchFirstNegative();
    }

    @Test
    void testFindFirstNegative() {
        int[] numbers = {10, 5, 8, -3, 7, -1, 4};
        assertEquals(3, searchFirstNegative.findFirstNegative(numbers));
    }

    @Test
    void testNoNegativeNumbers() {
        int[] numbers = {10, 5, 8, 3, 7, 1, 4};
        assertEquals(-1, searchFirstNegative.findFirstNegative(numbers));
    }

    @Test
    void testFirstElementNegative() {
        int[] numbers = {-10, 5, 8, 3, 7, 1, 4};
        assertEquals(0, searchFirstNegative.findFirstNegative(numbers));
    }
}
