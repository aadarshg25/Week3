package stringbuffertesting.compareperformance;

import com.tit.week03.day04.stringbuffer.compareperformance.ComparePerformance;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComparePerformanceTesting {
    ComparePerformance comparePerformance;

    @BeforeEach
    void objectCreation(){
        comparePerformance = new ComparePerformance();
    }

    @Test
    void testWithNormalString(){
        StringBuilder stringBuilder = new StringBuilder("Hello");
        StringBuffer stringBuffer = new StringBuffer("Hello");
        assertEquals(true,comparePerformance.isFast(comparePerformance.measureTime(stringBuilder,stringBuffer)));
    }
    @Test
    void testWithSpacedString(){
        StringBuilder stringBuilder = new StringBuilder("Hello World");
        StringBuffer stringBuffer = new StringBuffer("Hello World");
        assertEquals(true,comparePerformance.isFast(comparePerformance.measureTime(stringBuilder,stringBuffer)));
    }

}
