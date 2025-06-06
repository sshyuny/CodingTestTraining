package programmers.level1;

/**
 * 푸드 파이트 대회
 * https://school.programmers.co.kr/learn/courses/30/lessons/134240
 */
class FoodFighterContest {
    public static void main(String[] args) {

        int[] input1 = {1, 3, 4, 6};
        int[] input2 = {1, 7, 1, 2};
        String answer1 = "1223330333221";
        String answer2 = "111303111";

        System.out.println( Solution.solution(input1).equals(answer1) );
        System.out.println( Solution.solution(input2).equals(answer2) );
    }

    static class Solution {
        static String solution(int[] food) {
            String front = "";
            String end = "";
            int length = food.length;
            
            for (int i = 0; i < length; i++) {
                int num = food[i];
                if (num < 2) continue;
                int curAvail = num / 2;
                
                for (int j = 0; j < curAvail; j++) {
                    front = front + i;
                    end = i + end;
                }
            }
            
            String answer = front + "0" + end;
            return answer;
        }
    }
}
