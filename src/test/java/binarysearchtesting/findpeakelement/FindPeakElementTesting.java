package binarysearchtesting.findpeakelement;

import static org.junit.jupiter.api.Assertions.*;

import com.tit.week03.day04.binarysearch.findpeakelement.FindPeakElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FindPeakElementTesting {
    FindPeakElement findPeakElement;

    @BeforeEach
    void objectCreation() {
        findPeakElement = new FindPeakElement();
    }

    @Test
    void testSingleElementArray() {
        int[] arr = {5};
        assertEquals(0, findPeakElement.findPeakElement(arr));
    }

    @Test
    void testMultiplePeaks() {
        int[] arr = {1, 2, 3, 1, 5, 6, 4};
        int peakIndex = findPeakElement.findPeakElement(arr);
        assertTrue((peakIndex == 0 || arr[peakIndex] > arr[peakIndex - 1]) && (peakIndex == arr.length - 1 || arr[peakIndex] > arr[peakIndex + 1]));
    }
}

