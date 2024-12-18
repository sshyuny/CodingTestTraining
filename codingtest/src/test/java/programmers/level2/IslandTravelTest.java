package programmers.level2;

import static org.junit.Assert.assertTrue;
import java.util.Arrays;

import org.junit.Test;

public class IslandTravelTest {

    IslandTravel islandTravel = new IslandTravel();

    @Test
    public void test1() {
        String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
        int[] rightAns = {1, 1, 27};

        int[] result = islandTravel.solution(maps);

        assertTrue(Arrays.equals(result, rightAns));
    }

    @Test
    public void test2() {
        String[] maps = {"XXX","XXX","XXX"};
        int[] rightAns = {-1};

        int[] result = islandTravel.solution(maps);

        assertTrue(Arrays.equals(result, rightAns));
    }
}
