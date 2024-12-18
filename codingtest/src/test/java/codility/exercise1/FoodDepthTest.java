package codility.exercise1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import codility.exercise1.FoodDepth.FoodDepthSolution1;

public class FoodDepthTest {
    
    FoodDepth foodDepth = new FoodDepth();
    FoodDepthSolution1 solution1 = foodDepth.new FoodDepthSolution1();

    final int[] given1 = {1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2};
    final int rightAns1 = 2;

    final int[] given2 = {5};
    final int rightAns2 = 0;

    @Test
    public void solution1_test() {
        int ans1 = solution1.solution(given1);
        assertEquals(ans1, rightAns1);

        int ans2 = solution1.solution(given2);
        assertEquals(ans2, rightAns2);
    }
}
