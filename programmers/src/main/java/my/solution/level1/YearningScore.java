package my.solution.level1;

import java.util.HashMap;
import java.util.Map;

/**
 * 추억점수
 * https://school.programmers.co.kr/learn/courses/30/lessons/176963
 */
class YearningScore {

    private String[] name;
    private int[] yearning;
    private String[][] photo;
    private int[] rightAns;

    YearningScore (String[] name, int[] yearning, String[][] photo, int[] rightAns) {
        this.name = name;
        this.yearning = yearning;
        this.photo = photo;
        this.rightAns = rightAns;
    }

    boolean solve() {
        Solution solution = this.new Solution();
        int[] thisResult = solution.solution(name, yearning, photo);

        int thisLength = thisResult.length;
        if (rightAns.length != thisLength) return false;
        for (int i = 0; i < thisLength; i++) {
            if (thisResult[i] != rightAns[i]) return false;
        }
        return true;
    } 

    class Solution {

        int[] solution(String[] name, int[] yearning, String[][] photo) {
            int nameLength = name.length;
            Map<String, Integer> yNums = new HashMap<>();
            for (int i = 0; i < nameLength; i++) {
                yNums.put(name[i], yearning[i]);
            }
            
            int photoLength = photo.length;
            int[] answer = new int[photoLength];
            for (int i = 0; i < photoLength; i++) {
                answer[i] = calculateYearningScore(yNums, photo[i]);
            }
            
            return answer;
        }
        
        int calculateYearningScore(Map<String, Integer> yNums, String[] onePhoto) {
            int sum = 0;
            for (String onePerson : onePhoto) {
                if (!yNums.containsKey(onePerson)) continue;
                sum += yNums.get(onePerson);
            }
            return sum;
        }
    }
}
