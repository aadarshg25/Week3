package binarysearchtesting.findrotationpoint;

import static org.junit.jupiter.api.Assertions.*;

import com.tit.week03.day04.binarysearch.findrotationpoint.FindRotationPoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FindRotationPointTesting {
    FindRotationPoint findRotationPoint;

    @BeforeEach
    void objectCreation() {
        findRotationPoint = new FindRotationPoint();
    }

    @Test
    void testFindRotationPoint() {
        int[] arr = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        assertEquals(3, findRotationPoint.findRotationPoint(arr));
    }

    @Test
    void testAlreadySortedArray() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertEquals(0, findRotationPoint.findRotationPoint(arr));
    }

    @Test
    void testSingleElementArray() {
        int[] arr = {5};
        assertEquals(0, findRotationPoint.findRotationPoint(arr));
    }
}
