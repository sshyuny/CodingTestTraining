package codility.conteset2017;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import codility.contest2017.SocksLaundering;
import codility.contest2017.SocksLaundering.*;

public class SocksLaunderingTest {
    
    SocksLaundering sol = new SocksLaundering();
    SocksLaundering1 sol1 = sol.new SocksLaundering1();
    SocksLaundering2 sol2 = sol.new SocksLaundering2();

    int k1 = 2;
    int[] c1 = new int[] {1, 2, 1, 1};
    int[] d1 = new int[] {1, 4, 3, 2, 4};
    int rightAns1 = 3;

    int k2 = 3;
    int[] c2 = new int[] {1, 2, 1, 1};
    int[] d2 = new int[] {1, 4, 3, 2, 4};
    int rightAns2 = 3;

    int k3 = 0;
    int[] c3 = new int[] {1, 2, 3, 4};
    int[] d3 = new int[] {3, 2, 1, 5};
    int rightAns3 = 0;


    @Test
    public void solution2() {

        int ans1 = sol2.solution(k1, c1, d1);
        int ans2 = sol2.solution(k2, c2, d2);
        int ans3 = sol2.solution(k3, c3, d3);

        assertEquals(rightAns1, ans1);
        assertEquals(rightAns2, ans2);
        assertEquals(rightAns3, ans3);
    }

    @Test
    public void soluiton1() {

        int ans1 = sol1.solution(k1, c1, d1);

        assertEquals(rightAns1, ans1);
    }
}
