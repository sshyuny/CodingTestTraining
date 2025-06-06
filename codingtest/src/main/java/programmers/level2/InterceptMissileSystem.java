package programmers.level2;

import java.util.Arrays;

/**
 * 요격 시스템
 * https://school.programmers.co.kr/learn/courses/30/lessons/181188
 */
public class InterceptMissileSystem {

    public int solution(int[][] targets) {
        
        Arrays.sort(targets, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        
        int count = 0;
        int location = 0;

        for (int[] target : targets) {
            if (location <= target[1] && location > target[0]) {
                continue;
            }
            else {
                location = target[1];
                ++count;
            }
        }
        
        return count;
    }

}
