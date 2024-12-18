package codility.exercise1;

/*
 * Codility
 * https://app.codility.com/programmers/trainings/1/flood_depth/
 */
public class FoodDepth {
    
    /*
     * score: 33%
     * https://app.codility.com/demo/results/training9PCA33-754/
     */
    public class FoodDepthSolution1 {
        
        public int solution(int[] A) {
            int answer = 0;

            for (int i = 1; i < A.length - 1; i++) {
                int temp = findDepth(i, A);
                if (temp > answer) { answer = temp; }
            }

            return answer;
        }

        int findDepth(int curIdx, int[] map) {
            if (curIdx == 0 || curIdx >= map.length - 1) { return 0; }

            int leftBig = 0;
            int rightBig = 0;

            for (int i = curIdx - 1; i > 0; i--) {
                if (map[i] > leftBig && map[i] > map[curIdx]) {
                    leftBig = map[i];
                }
            }
            for (int i = curIdx + 1; i < map.length; i++) {
                if (map[i] > rightBig && map[i] > map[curIdx]) {
                    rightBig = map[i];
                }
            }

            if (leftBig == 0 || rightBig == 0) { return 0; }

            int standard = leftBig < rightBig ? leftBig : rightBig;

            // System.out.println(curIdx + " " + map[curIdx] + " " + leftBig + " " + rightBig);

            return standard - map[curIdx];
        }
    }

}
