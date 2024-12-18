package programmers.level2;

import java.util.*;

/**
 * 무인도 여행
 * https://school.programmers.co.kr/learn/courses/30/lessons/154540
 */
class IslandTravel {
    
    int[] solution(String[] maps) {
        int colNum = maps[0].length();
        int rowNum = maps.length;
        
        int[][] usedZoneMap = new int[rowNum][colNum];
        int[][] originMap = new int[rowNum][colNum];
        
        for (int row = 0; row < rowNum; row++) {
            String strRow = maps[row].replace("X", "0");
            Arrays.fill(usedZoneMap[row], 0);
            
            for (int col = 0; col < colNum; col++) {
                String str = strRow.charAt(col) + "";
                originMap[row][col] = Integer.valueOf(str);
            }
        }
        
        List<Integer> resultList = new ArrayList<>();
        
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if (!canGoNext(usedZoneMap, col, row, colNum, rowNum)) continue;
                int result = addAllFood(usedZoneMap, originMap, col, row, colNum, rowNum);
                if (result == 0) continue;
                resultList.add(result);
            }
        }
        
        int resultListSize = resultList.size();
        if (resultListSize == 0) return new int []{-1};
        
        int[] answer = new int[resultListSize];
        for (int i = 0; i < resultListSize; i++) {
            answer[i] = resultList.get(i);
        }
        
        Arrays.sort(answer);
        return answer;
    }
    
    int addAllFood(int[][] usedZoneMap, int[][] originMap, int curCol, int curRow, 
                  int mapColNum, int mapRowNum) {
        
        int curZoneFood = originMap[curRow][curCol];
        //int[][] copidUsedZoneMap;
        usedZoneMap[curRow][curCol] = 1;
        
        if (curZoneFood == 0) return 0;
        int afterFoodSum = 0;
        
        if (canGoNext(usedZoneMap, curCol-1, curRow, mapColNum, mapRowNum)) {
            afterFoodSum += addAllFood(usedZoneMap, originMap, curCol-1, curRow, mapColNum, mapRowNum);
        }
        if (canGoNext(usedZoneMap, curCol, curRow-1, mapColNum,  mapRowNum)) {
            afterFoodSum += addAllFood(usedZoneMap, originMap, curCol, curRow-1, mapColNum, mapRowNum);
        }
        if (canGoNext(usedZoneMap, curCol+1, curRow, mapColNum, mapRowNum)) {
            afterFoodSum += addAllFood(usedZoneMap, originMap, curCol+1, curRow, mapColNum, mapRowNum);
        }
        if (canGoNext(usedZoneMap, curCol, curRow+1, mapColNum, mapRowNum)) {
            afterFoodSum += addAllFood(usedZoneMap, originMap, curCol, curRow+1, mapColNum, mapRowNum);
        }
        
        return curZoneFood + afterFoodSum;
    }
    
    boolean canGoNext(int[][] usedZoneMap, int curCol, int curRow, 
                     int mapColNum, int mapRowNum) {
        if (curRow >= mapRowNum || curRow < 0) return false;
        if (curCol >= mapColNum || curCol < 0) return false;
        if (usedZoneMap[curRow][curCol] == 1) return false;
        return true;
    }

}
