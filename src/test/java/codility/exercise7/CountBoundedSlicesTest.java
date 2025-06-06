package codility.exercise7;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import codility.exercise7.CountBoundedSlices.CountBoundedSlicesSolution1;
import codility.exercise7.CountBoundedSlices.CountBoundedSlicesSolution2;

public class CountBoundedSlicesTest {
    
    CountBoundedSlices sol = new CountBoundedSlices();
    CountBoundedSlicesSolution1 solution1 = sol.new CountBoundedSlicesSolution1();
    CountBoundedSlicesSolution2 solution2 = sol.new CountBoundedSlicesSolution2();

    final int[] given1 = {3, 5, 7, 6, 3};
    final int rightAns1 = 9;

    @Test
    public void solution2_test() {
        int ans = solution2.solution(2, given1);
        assertEquals(ans, rightAns1);
    }

    @Test
    public void solution1_test() {
        int ans = solution1.solution(2, given1);
        assertEquals(ans, rightAns1);
    }
}
