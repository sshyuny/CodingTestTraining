package my.solution.level2;

/**
 * 뒤에 있는 큰 수 찾기
 * https://school.programmers.co.kr/learn/courses/30/lessons/154539
 * 
 * 채점 결과: 실패(시간초과) - 테스트 20 ~ 23
 */
class FindBiggerNumInBehindOutOfTime {
    
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
