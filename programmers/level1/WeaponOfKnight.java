import java.util.*;


/**
 * 기사단원의 무기
 * https://school.programmers.co.kr/learn/courses/30/lessons/136798
 */
class WeaponOfKnight {
    
    public static void main(String[] args) {
        
        int[] values1 = {5, 3, 2, 10};
        int[] values2 = {10, 3, 2, 21};
        
        System.out.println("1번. " + score(values1));
        System.out.println("2번. " + score(values2));
    }

    static boolean score(int[] values) {
        SolutionTimeOut solution = new SolutionTimeOut();
        int answer = solution.solution(values[0], values[1], values[2]);
        return answer == values[3];
    }


    /**
     * 시간 초과
     */
    static class SolutionTimeOut {

        int solution(int number, int limit, int power) {
            int answer = 0;
            
            for (int curNum = 1; curNum <= number; curNum++) {
                int divisorNum = findDivisorNum(curNum);
                
                // System.out.println(divisorNum);
                
                if (divisorNum > limit) answer += power;
                else answer += divisorNum;
            }
            
            return answer;
        }
        
        int findDivisorNum(int curNum) {
            if (curNum == 1) return 1;
            
            Map<Integer, Integer> numbers;
            if (curNum % 2 == 0)
                numbers = makeNumbersOfEven(curNum);
            else
                numbers = makeNumbersOfOdd(curNum);
            
            int divisorNum = 0;
            for (int i = 2; i < curNum; i++) {
                if (!numbers.containsKey(i)) continue;
                divisorNum += numbers.get(i);
            }
            return divisorNum + 2;
        } 
        
        Map<Integer, Integer> makeNumbersOfEven(int curNum) {
            
            Map<Integer, Integer> numbers = new HashMap<>();
            for (int i = 2; i < curNum / 2 + 1; i++) {
                if (numbers.containsKey(i)) continue;
                if (curNum % i != 0) {
                    numbers.put(i, 0);
                    continue;
                }
                
                numbers.put(i, 1);
                int quotient = curNum / i;
                numbers.put(quotient, 1);
            }
            
            return numbers;
        }
        Map<Integer, Integer> makeNumbersOfOdd(int curNum) {
            
            Map<Integer, Integer> numbers = new HashMap<>();
            for (int i = 3; i < curNum / 2 + 1; i+=2) {
                if (numbers.containsKey(i)) continue;
                if (curNum % i != 0) {
                    numbers.put(i, 0);
                    continue;
                }
                
                numbers.put(i, 1);
                int quotient = curNum / i;
                numbers.put(quotient, 1);
            }
            
            return numbers;
        }
        
    }

    /**
     * 메모리 초과
     */
    class SolutionMemoryOut {
        public int solution(int number, int limit, int power) {
        
            Map<Integer, Map<Integer, Integer>> numberMap = new HashMap<>();
            
            for (int curNum = 1; curNum <= number; curNum++) {
                if (numberMap.containsKey(curNum)) {
                    if (numberMap.get(curNum).containsKey(curNum)) continue;
                }
                
                if (curNum == 1) {
                    Map<Integer, Integer> divisorMap = new HashMap<>();
                    divisorMap.put(1, 1);
                    numberMap.put(1, divisorMap);
                    continue;
                }
                
                Map<Integer, Integer> divisorMap = findDivisorMap(curNum, numberMap);
                numberMap.put(curNum, divisorMap);
                
                int possibleDouble = number / curNum;
                if (possibleDouble < 2) continue;
                for (int i = 2; i <= possibleDouble; i++) {
                    if (numberMap.containsKey(curNum*i)) {
                        Map<Integer, Integer> addedMap = addTwoMap(numberMap.get(curNum*i), divisorMap);
                        numberMap.put(curNum * i, addedMap);
                        continue;
                    }
                    numberMap.put(curNum * i, new HashMap<>(divisorMap));
                }
            }
            
            int answer = 0;
            for (Integer numIdxKey : numberMap.keySet()) {
                Map<Integer, Integer> divisorMap = numberMap.get(numIdxKey);
                int thisIdxAttack = 0;
                for (Integer divisorIdxKey : divisorMap.keySet()) {
                    Integer curNum = divisorMap.get(divisorIdxKey);
                    thisIdxAttack += curNum;
                }
                System.out.println(thisIdxAttack);
                if (thisIdxAttack > limit) answer += power;
                else answer += thisIdxAttack;
            }
            
            return answer;
        }
        
        Map<Integer, Integer> findDivisorMap(int curNum, 
                                             Map<Integer, Map<Integer, Integer>> numberMap) {
            Map<Integer, Integer> divisorMap;
            
            if (numberMap.containsKey(curNum)) {
                divisorMap = numberMap.get(curNum);
                int size = divisorMap.size();
                for (int i = size + 1; i < curNum; i++) {
                    if (curNum % i == 0) {
                        divisorMap.put(i, 1);
                    } else {
                        divisorMap.put(i, 0);
                    }
                }
                divisorMap.put(curNum, 1);
                return divisorMap;
            }
            
            divisorMap = new HashMap<>();
            for (int i = 2; i < curNum; i++) {
                if (curNum % i == 0) {
                    divisorMap.put(i, 1);
                } else {
                    divisorMap.put(i, 0);
                }
            }
            divisorMap.put(1, 1);
            divisorMap.put(curNum, 1);
            return divisorMap;
        } 
        
        Map<Integer, Integer> addTwoMap(Map<Integer, Integer> firstMap, Map<Integer, Integer> secMap) {
            Map<Integer, Integer> addedMap = new HashMap<>();
            int size = firstMap.size();
            for (int i = 1; i < size; i++) {
                if (firstMap.get(i) == 1){
                    addedMap.put(i, 1);
                    continue;
                }
                if (secMap.get(i) == 1){
                    addedMap.put(i, 1);
                    continue;
                }
                addedMap.put(i, 0);
            }
            return addedMap;
        }
    }
}
