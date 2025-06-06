package programmers.level2;

import java.util.*;

/**
 * 뒤에 있는 큰 수 찾기
 * https://school.programmers.co.kr/learn/courses/30/lessons/154539
 */
class FindBiggerNumInBehind {

    /*
     * 채점 결과: 실패(시간초과) - 테스트 20, 22
     */
    class FindBiggerNumInBehindOutOfTime3 {
        public int[] solution(int[] numbers) {
            int length = numbers.length;
            int[] answer = new int[length];
            
            answer[length - 1] = -1;
            int biggestNum = numbers[length - 1];
            
            for (int i = length - 2; i >= 0; i--) {
                int curNum = numbers[i];
                int nextNum = numbers[i + 1];
                
                if (curNum < nextNum) {
                    if (biggestNum < nextNum) biggestNum = nextNum;
                    answer[i] = nextNum;
                    continue;
                }
                
                if (curNum >= biggestNum) {
                    answer[i] = -1;
                    continue;
                }
                
                findBiggerNum(numbers, answer, i, curNum, length);
            }
            
            return answer;
        }
        
        void findBiggerNum(int[] numbers, int[] answer, 
                           int curIdx, int curNum, int length) {
            for (int i = curIdx + 2; i <= length - 1; i++) {
                int nextNum = numbers[i];
                
                if (curNum < nextNum) {
                    answer[curIdx] = nextNum;
                    return;
                }
            }
            answer[curIdx] = -1;
        }
    }

    /*
     * 채점 결과: 실패(시간초과) - 테스트 22
     */
    class FindBiggerNumInBehindOutOfTime2 {
        public int[] solution(int[] numbers) {
            int length = numbers.length;
            int[] answer = new int[length];
            
            Map<Integer, Integer> idxValueMap = new HashMap<>();
            
            for (int i = 0; i < length - 1; i++) {
                findBiggerNum(numbers, answer, idxValueMap, i, length);
            }
            
            if (idxValueMap.size() > 0) {
                Set<Integer> ks = idxValueMap.keySet();
                for (Integer curKey : ks) {
                    answer[curKey] = -1;
                }    
            }
                
            answer[length - 1] = -1;
            return answer;
        }
        
        void findBiggerNum(int[] numbers, int[] answer, Map<Integer, Integer> idxValueMap, int idx, int length) {
            int curNum = numbers[idx];
            int nextNum = numbers[idx + 1];
            
            if (curNum >= nextNum) {
                idxValueMap.put(idx, curNum);
                return;
            }
            
            answer[idx] = nextNum;
            
            if (idxValueMap.size() == 0) return;
            
            Iterator<Integer> iterator = idxValueMap.keySet().iterator();
            while (iterator.hasNext()) {
                Integer curKey = iterator.next();
                if (numbers[curKey] >= nextNum) continue;
                answer[curKey] = nextNum;
                iterator.remove();
            }
        }
    }

    /*
     * 채점 결과: 실패(시간초과) - 테스트 20 ~ 23
     */
    class FindBiggerNumInBehindOutOfTime1 {

        int[] solution(int[] numbers) {
            int length = numbers.length;
            
            int[] answer = new int[length];
            
            for (int i = 0; i < length; i++) {
                int result = findBiggerNum(numbers, i, length);
                answer[i] = result;
            }
            
            return answer;
        }
        
        int findBiggerNum(int[] numbers, int idx, int length) {
            if (idx == length - 1) return -1;
            int curNum = numbers[idx];
            
            for (int i = idx + 1; i < length; i++) {
                int temp = numbers[i];
                if (curNum < temp) return temp;
            }
            return -1;
        }
    }
    

}
