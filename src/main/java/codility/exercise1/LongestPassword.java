package codility.exercise1;

/*
 * Codility
 * https://app.codility.com/programmers/trainings/1/longest_password/
 */
public class LongestPassword {

    /*
     * Score 100%
     * https://app.codility.com/demo/results/trainingJGUY9G-3BF/
     * 
     * Score: 60%
     * https://app.codility.com/demo/results/training65MT86-SKR/
     */
    public class LongestPasswordSolution2 {

        public int solution(String S) {
            String[] strs = S.split(" ");
    
            int ans = -1;  // Score 100% version
            // int ans = 0;  // Score 60% version
    
            for (String str : strs) {
                if (!isValidPassword(str)) { continue; }
                int strLength = str.length();
                if (ans < strLength) {
                    ans = strLength;
                }
            }
    
            return ans;
        }
    
        boolean isValidPassword(String s) {
            char[] chars = s.toCharArray();
            int lettersNum = 0;
            int digitsNum = 0;
    
            for (char c : chars) {
                boolean res1 = Character.isLetter(c);
                boolean res2 = Character.isDigit(c);
                if(res1) {
                    ++lettersNum;
                }
                if(res2) {
                    ++digitsNum;
                }
                if (!res1 && !res2) {
                    return false;
                }
            }
    
            if (lettersNum % 2 != 0) {
                return false;
            }
            if (digitsNum % 2 != 1) {
                return false;
            }
    
            return true;
        }
    }
    
    /*
     * Score: 0%
     * https://app.codility.com/demo/results/trainingEBMVX5-6S6/
     */
    public class LongestPasswordSolution1 {

        public int solution(String S) {
            String[] strs = S.split(" ");
    
            int ans = 0;
    
            for (String str : strs) {
                if (!isValidPassword(str)) { continue; }
                int strLength = str.length();
                if (ans < strLength) {
                    ans = strLength;
                }
            }
    
            return ans;
        }
    
        boolean isValidPassword(String s) {
            char[] chars = s.toCharArray();
            int lettersNum = 0;
            int digitsNum = 0;
    
            for (char c : chars) {
                boolean res1 = Character.isLetter(c);
                boolean res2 = Character.isDigit(c);
                if(res1) {
                    ++lettersNum;
                }
                if(res2) {
                    ++digitsNum;
                }
                if (!res1 && !res2) {
                    return false;
                }
            }
    
            if (!(lettersNum == 0)  && (lettersNum / 2 == 0)) {
                return false;
            }
            if (digitsNum / 2 != 1) {
                return false;
            }
    
            return true;
        }
    }

}
