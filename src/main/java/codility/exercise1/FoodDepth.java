package codility.exercise1;

/*
 * Codility
 * https://app.codility.com/programmers/trainings/1/flood_depth/
 */
public class FoodDepth {


    public class FoodDepthSolution5 {
        
        public int solution(int[] A) {
            return calculate(A, 0, 0, 0, 0);
        }

        public int calculate(int[] maps, int curIdx, 
                int highestIdx, int lowestIdx, int depth) {

            int nextIdx = curIdx + 1;

            if (nextIdx >= maps.length) return depth;

            int tempDepth = 0;
            
            if (maps[nextIdx] > maps[highestIdx]) {
                tempDepth = calculate(maps, nextIdx, nextIdx, nextIdx, maps[highestIdx] - maps[lowestIdx]);
            } else if (maps[nextIdx] < maps[lowestIdx]) {
                tempDepth = calculate(maps, nextIdx, highestIdx, nextIdx, depth);
            } else if (maps[nextIdx] == maps[curIdx]) {
                tempDepth = calculate(maps, nextIdx, highestIdx, lowestIdx, depth);
            } else {
                tempDepth = calculate(maps, nextIdx, highestIdx, lowestIdx, maps[nextIdx] - maps[lowestIdx]);
            }
            
            return tempDepth > depth ? tempDepth : depth;
        }
        
    }

    /*
     * score: 58%
     * https://app.codility.com/demo/results/training5QF5JN-4UW/
     * https://app.codility.com/demo/results/trainingRH4X5P-YXV/
     */
    public class FoodDepthSolution4 {

        public int solution(int[] A) {
            return calculate(A, 0, 0, 0, 0);
        }

        public int calculate(int[] maps, int curIdx, 
                int highestIdx, int lowestIdx, int depth) {

            int nextIdx = curIdx + 1;

            if (nextIdx >= maps.length) return depth;

            int tempDepth = 0;
            
            if (maps[nextIdx] > maps[highestIdx]) {
                tempDepth = calculate(maps, nextIdx, nextIdx, nextIdx, maps[highestIdx] - maps[lowestIdx]);
            } else if (maps[nextIdx] < maps[lowestIdx]) {
                tempDepth = calculate(maps, nextIdx, highestIdx, nextIdx, depth);
            } else if (maps[nextIdx] == maps[curIdx]) {
                tempDepth = calculate(maps, nextIdx, highestIdx, lowestIdx, depth);
            } else {
                tempDepth = calculate(maps, nextIdx, highestIdx, lowestIdx, maps[nextIdx] - maps[lowestIdx]);
            }
            
            return tempDepth > depth ? tempDepth : depth;
        }
    }
    
    /*
     * score: 0%
     * https://app.codility.com/demo/results/trainingTZQTDS-XJD/
     */
    public class FoodDepthSolution3 {

        public int solution(int[] A) {
            return calculate(A, 0, 0, 0, 0);
        }

        public int calculate(int[] maps, int curIdx, 
                int highestIdx, int lowestIdx, int score) {

            if (curIdx > maps.length) return score;

            for (int nextIdx = curIdx + 1; nextIdx < maps.length - 1; nextIdx++) {

                if (maps[nextIdx] > maps[highestIdx]) {
                    int tempM = calculate(maps, nextIdx, nextIdx, nextIdx, score);
                    int tempC = maps[highestIdx] - maps[lowestIdx];
                    return tempM > tempC ? tempM : tempC;
                }

                if (maps[nextIdx] < maps[lowestIdx]) {
                    return calculate(maps, nextIdx, highestIdx, nextIdx, score);
                }

                if (maps[nextIdx] == maps[curIdx]) {
                    return calculate(maps, nextIdx, highestIdx, lowestIdx, score);
                }

                calculate(maps, nextIdx, highestIdx, lowestIdx, maps[nextIdx] - maps[lowestIdx]);
            }

            return score;
        }
    }

    /*
     * score: 8%
     * https://app.codility.com/demo/results/trainingF84EJK-D2D/
     */
    public class FoodDepthSolution2 {
        public int solution(int[] A) {
            return calculate(A, 0, 0, 0);
        }
    
        public int calculate(int[] maps, int curIdx, 
                int highestIdx, int lowestIdx) {
    
            if (curIdx >= maps.length - 1) return -1;
    
            for (int nextIdx = curIdx + 1; nextIdx < maps.length - 1; nextIdx++) {
    
                if (maps[nextIdx] > maps[highestIdx]) {
                    int tempM = calculate(maps, nextIdx, nextIdx, nextIdx);
                    int tempC = maps[highestIdx] - maps[lowestIdx];
                    return tempM > tempC ? tempM : tempC;
                }
    
                if (maps[nextIdx] < maps[lowestIdx]) {
                    return calculate(maps, nextIdx, highestIdx, nextIdx);
                }
    
                if (maps[nextIdx] == maps[curIdx]) {
                    return calculate(maps, nextIdx, highestIdx, lowestIdx);
                }
    
            }
            return 0;
        }
    }


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
