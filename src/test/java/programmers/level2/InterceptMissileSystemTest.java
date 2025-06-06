package programmers.level2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class InterceptMissileSystemTest {

    InterceptMissileSystem solution = new InterceptMissileSystem();

    int[][] targets = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};
    int rightAns = 3;
    
    @Test
    public void test() {
        int ans = solution.solution(targets);

        assertEquals(ans, rightAns);
    }

}
