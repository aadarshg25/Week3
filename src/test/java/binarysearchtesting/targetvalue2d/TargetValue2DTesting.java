package binarysearchtesting.targetvalue2d;

import static org.junit.jupiter.api.Assertions.*;

import com.tit.week03.day04.binarysearch.targetvalue2d.TargetValue2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TargetValue2DTesting {
    TargetValue2D targetValue2D;

    @BeforeEach
    void objectCreation() {
        targetValue2D = new TargetValue2D();
    }

    @Test
    void testSearchMatrixTargetPresent() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        assertEquals(true, targetValue2D.searchMatrix(matrix, 3));
    }

    @Test
    void testSearchMatrixTargetNotPresent() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        assertEquals(false, targetValue2D.searchMatrix(matrix, 25));
    }

    @Test
    void testSearchMatrixEmptyMatrix() {
        int[][] matrix = {};
        assertEquals(false, targetValue2D.searchMatrix(matrix, 3));
    }
}

