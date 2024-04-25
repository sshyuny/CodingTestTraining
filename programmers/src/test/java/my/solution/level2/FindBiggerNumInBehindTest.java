package my.solution.level2;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class FindBiggerNumInBehindTest {

    FindBiggerNumInBehindOutOfTime findBiggerNumInBehindOutOfTime = new FindBiggerNumInBehindOutOfTime();
    
    @Test
    public void test1() {
        int[] numbers = {2, 3, 3, 5};
        int[] rightAns = {3, 5, 5, -1};
        
        int[] result = findBiggerNumInBehindOutOfTime.solution(numbers);

        assertTrue(Arrays.equals(result, rightAns));
    }

}
