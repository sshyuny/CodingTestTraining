package codility.exercise7;

import java.util.Arrays;

/* 
 * Codility
 * https://app.codility.com/programmers/trainings/7/count_bounded_slices/
 */
public class CountBoundedSlices {
    
    /*
     * score: 50%
     * https://app.codility.com/demo/results/trainingTHER9P-MFX/
     * Error Message: TIMEOUT ERROR
     */
    public class CountBoundedSliceSolution1 {

        public int solution(int K, int[] A) {
            int ans = 0;

            for (int i = 0; i < A.length; i++) {
                for (int j = i; j < A.length; j++) {
                    int[] newArr = Arrays.copyOfRange(A, i, j + 1);
                    
                    Arrays.sort(newArr);
                    if (newArr[newArr.length - 1] - newArr[0] <= K) {
                        ++ans;
                    }
                }
            }

            return ans;
        }
    }
    
}
