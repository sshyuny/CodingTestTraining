package programmers.level2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TwoIntBetweenTwoCircleTest {
    
    TwoIntBetweenTwoCircle solution = new TwoIntBetweenTwoCircle();
    int r1 = 2;
    int r2 = 3;
    int rightAns = 20;

    @Test
    public void test10() {

        long ans = solution.solution10(r1, r2);

        assertEquals(rightAns, ans);
    }

    @Test
    public void test4() {
        
        long ans = solution.solution4(r1, r2);

        assertEquals(rightAns, ans);
    }

    @Test
    public void test1() {

        long ans = solution.solution1(r1, r2);

        assertEquals(rightAns, ans);
    }

}
