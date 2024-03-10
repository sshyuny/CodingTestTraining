package my.solution.level1;


import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class YearningScoreTest {
    
    @Test
    public void test1() {

        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"},
                            {"may", "kein", "brin", "deny"},
                            {"kon", "kain", "may", "coni"}};
        int[] rightAns = {19, 15, 6};

        YearningScore yearningScore = new YearningScore(name, yearning, photo, rightAns);
        assertTrue(yearningScore.solve());
    }

    @Test
    public void test2() {

        String[] name = {"kali", "mari", "don"};
        int[] yearning = {11, 1, 55};
        String[][] photo = {{"kali", "mari", "don"}, {"pony", "tom", "teddy"}, {"con", "mona", "don"}};
        int[] rightAns = {67, 0, 55};

        YearningScore yearningScore = new YearningScore(name, yearning, photo, rightAns);
        assertTrue(yearningScore.solve());
    }

    @Test
    public void test3() {

        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may"},{"kein", "deny", "may"}, {"kon", "coni"}};
        int[] rightAns = {5, 15, 0};

        YearningScore yearningScore = new YearningScore(name, yearning, photo, rightAns);
        assertTrue(yearningScore.solve());
    }
}
