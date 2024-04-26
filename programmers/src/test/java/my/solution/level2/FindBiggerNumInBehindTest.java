package my.solution.level2;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import my.solution.level2.FindBiggerNumInBehind.FindBiggerNumInBehindOutOfTime1;
import my.solution.level2.FindBiggerNumInBehind.FindBiggerNumInBehindOutOfTime2;

public class FindBiggerNumInBehindTest {

    FindBiggerNumInBehind findBiggerNumInBehind = new FindBiggerNumInBehind();
    FindBiggerNumInBehindOutOfTime1 findBiggerNumInBehindOutOfTime1 = findBiggerNumInBehind.new FindBiggerNumInBehindOutOfTime1();
    FindBiggerNumInBehindOutOfTime2 findBiggerNumInBehindOutOfTime2 = findBiggerNumInBehind.new FindBiggerNumInBehindOutOfTime2();
    
    @Test
    public void test1() {
        int[] numbers = {2, 3, 3, 5};
        int[] rightAns = {3, 5, 5, -1};
        
        int[] result = findBiggerNumInBehindOutOfTime1.solution(numbers);

        assertTrue(Arrays.equals(result, rightAns));
    }

    @Test
    public void test2() {
        int[] numbers = {2, 3, 3, 5};
        int[] rightAns = {3, 5, 5, -1};
        
        int[] result = findBiggerNumInBehindOutOfTime2.solution(numbers);

        assertTrue(Arrays.equals(result, rightAns));
    }

}
