package my.solution.level1;

/**
 * 대충 만든 자판
 * https://school.programmers.co.kr/learn/courses/30/lessons/160586
 */
class WeirdKeyboard {

    public static void main(String[] args) {

        String[] keymap1 = {"ABACD", "BCEFD"};
        String[] keymap2 = {"AA"};
        String[] keymap3 = {"AGZ", "BSSS"};

        String[] targets1 = {"ABCD","AABB"};
        String[] targets2 = {"B"};
        String[] targets3 = {"ASA","BGZ"};

        int[] answer1 = {9, 4};
        int[] answer2 = {-1};
        int[] answer3 = {4, 6};

        System.out.println( "1번. " + score(Solution.solution(keymap1, targets1), answer1) );
        System.out.println( "2번. " + score(Solution.solution(keymap2, targets2), answer2) );
        System.out.println( "3번. " + score(Solution.solution(keymap3, targets3), answer3) );
    }

    static boolean score(int[] solution, int[] answer) {
        int length = solution.length;

        if (length != answer.length) return false;

        for (int idx = 0; idx < length; idx++) {
            if (solution[idx] != answer[idx]) return false;
        }

        return true;
    }
    
    static class Solution {
        static int[] solution(String[] keymap, String[] targets) {
            // target n번째 글자 누르는데 필요한 최소 횟수
            // keymap n번째 키에서 target 글자 몇번째인지
            // keymap 모든 글자에서 target 글자 없는지
            
            // 타겟들, 타겟, 타겟알파벳
            
            int targetsLth = targets.length;
            int[] answer = new int[targetsLth];
            
            // 타겟들 순환
            for (int targetsIdx = 0; targetsIdx < targetsLth; targetsIdx++) {
                answer[targetsIdx] = findSumPressNum(targets[targetsIdx], keymap); 
            }
            
            return answer;
        }

        static int findSumPressNum(String target, String[] keymap) {
            int targetLth = target.length();
            // 가장 적은 횟수 합
            int sumPressNum = 0;
            
            for (int targetIdx = 0; targetIdx < targetLth; targetIdx++) {
                // 이번 타겟알파벳
                String targetAlph = target.substring(targetIdx, targetIdx + 1);
                // 여러 키 중, 가장 적은 횟수
                int minPressNum = 101;
                
                // keymap 순환
                for (String key : keymap) {
                    // 현재 키에서, 타겟알파벳 누르기 위한 횟수
                    int curPressNum = key.indexOf(targetAlph);
                    
                    if (curPressNum == -1) continue;
                    if (curPressNum < minPressNum) minPressNum = curPressNum;
                }
    
                //아무 키에도 타겟알파벳이 없을 경우
                if (minPressNum == 101) {
                    return -1;
                }
                sumPressNum += minPressNum + 1;
            }
            return sumPressNum;
        }
    }
}
