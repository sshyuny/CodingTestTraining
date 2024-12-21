package codility.exercise9;

/*
 * Codility
 * https://app.codility.com/programmers/trainings/9/binary_gap/
 */
public class BinaryGap {

    /*
     * score: 100%
     * https://app.codility.com/demo/results/trainingFH2WPQ-E5Q/
     */
    public class BinaryGapSolution2 {

        public int solution(int N) {
            String str = Integer.toBinaryString(N);
            // System.out.println(str);
            return findGap(str);
        }
    
        public int findGap(String str) {
    
            int length = str.length();
            int ans = 0;
            int temp = 0;
    
            for (int i = 0; i < length; i++) {
                if (str.charAt(i) == '1') {
                    if (temp > 0) { ans = temp - 1 > ans ? temp - 1 : ans; }
                    temp = 1;
                } else {
                    if (temp > 0) { ++temp; }
                }
            }
    
            return ans;
        }
    }
    
    /*
     * score: 53%
     * https://app.codility.com/demo/results/trainingVQ9BXR-3X5/
     */
    public class BinaryGapSolution1 {
        public int solution(int N) {
            String str = Integer.toBinaryString(N);
            return findGap(str);
        }
    
        public int findGap(String str) {
    
            int length = str.length();
            int ans = 0;
            int temp = 0;
    
            for (int i = 0; i < length; i++) {
                if (str.charAt(i) == '1') {
                    if (temp == 0) { temp = 1; }
                    else { 
                        ans = temp - 1 > ans ? temp - 1 : ans;
                        temp = 0;
                    }
                } else {
                    if (temp > 0) { ++temp; }
                }
            }
    
            return ans;
        }
    }
    
}
