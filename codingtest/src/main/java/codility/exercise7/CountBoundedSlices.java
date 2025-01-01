package codility.exercise7;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/* 
 * Codility
 * https://app.codility.com/programmers/trainings/7/count_bounded_slices/
 */
public class CountBoundedSlices {

    /*
     * score: 50%
     * https://app.codility.com/demo/results/training9K7XCE-7K3/
     * Error Message: TIMEOUT ERROR
     */
    public class CountBoundedSlicesSolution2 {

        public int solution(int K, int[] A) {
            int ans = 0;
            int size = A.length;
            
            Deque<Integer> maxDeque = new ArrayDeque<>();
            Deque<Integer> minDeque = new ArrayDeque<>();
            
            for (int left = 0; left < size; left++) {
                maxDeque.clear();
                minDeque.clear();
                maxDeque.offerLast(left);
                minDeque.offerLast(left);

                for (int right = left; right < size; right++) {
                    if (A[maxDeque.peekLast()] < A[right]) {
                        maxDeque.clear();
                        maxDeque.offerLast(right);
                    } else if (A[maxDeque.peekLast()] == A[right]) {
                        maxDeque.offerLast(right);
                    }
                    if (A[minDeque.peekLast()] > A[right]) {
                        minDeque.clear();
                        minDeque.offerLast(right);
                    } else if (A[minDeque.peekLast()] == A[right]) {
                        minDeque.offerLast(right);
                    }
    
                    if (A[maxDeque.peekLast()] - A[minDeque.peekLast()] > K) {
                        ans += right - left;
                        break;
                    }
                    if (right == size - 1) {
                        ans += right - left + 1;
                    }
                }
            }

            return ans;
        }
    }
    
    /*
     * score: 50%
     * https://app.codility.com/demo/results/trainingTHER9P-MFX/
     * Error Message: TIMEOUT ERROR
     */
    public class CountBoundedSlicesSolution1 {

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
