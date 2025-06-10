package programmers.level2;

import java.math.BigDecimal;

/*
 * 두 원 사이의 정수 쌍
 * https://school.programmers.co.kr/learn/courses/30/lessons/181187
 */
public class TwoIntBetweenTwoCircle {

    /*
     * (SUCCESS)
     * 일곱 번째 시도: 빼먹었던 부분에서 long 변환 추가!!
     */
    public long solution10(int r1, int r2) {
        
        long count = 0;
        long r1Square = (long)r1 * (long)r1;
        long r2Square = (long)r2 * (long)r2;
        
        for (int x = 1; x <= r2; x++) {
            
            long xSquare = (long)x * (long)x;
            
            long yMaxSquare = (r2Square - xSquare) > 0 ? (r2Square - xSquare) : 0;
            long yMinSquare = (r1Square - xSquare) > 0 ? (r1Square - xSquare) : 0;

            double yMax = Math.sqrt(yMaxSquare);
            double yMin = Math.sqrt(yMinSquare);

            count += (long) (Math.floor(yMax) - Math.ceil(yMin) + 1);
        }
        
        return count * 4;
    }

    /*
     * (FAIL)
     * 여섯 번째 시도: 다시 BigDecimal 사용
     */
    public long solution9(int r1, int r2) {
        
        long count = 0;
        long r1Square = (long)r1 * (long)r1;
        long r2Square = (long)r2 * (long)r2;
        
        for (int x = 1; x <= r2; x++) {
            long xSquare = ((long)x)*((long)x);
            
            long yMaxSquare = (r2Square - xSquare) > 0 ? (r2Square - xSquare) : 0;
            long yMinSquare = (r1Square - xSquare) > 0 ? (r1Square - xSquare) : 0;

            BigDecimal yMax = BigDecimal.valueOf(Math.sqrt(yMaxSquare));
            BigDecimal yMin = BigDecimal.valueOf(Math.sqrt(yMinSquare));

            count += (long) (yMax.setScale(0, BigDecimal.ROUND_FLOOR).longValue() - 
                             yMin.setScale(0, BigDecimal.ROUND_CEILING).longValue() + 1);
        }
        
        return count * 4;
    }

    /*
     * (FAIL)
     * 다섯 번째 시도: double 제거
     */
    public long solution8(int r1, int r2) {
        
        long count = 0;
        long r1Square = r1 * r1;
        long r2Square = r2 * r2;
        
        for (int x = 1; x <= r2; x++) {
            long xSquare = ((long)x)*((long)x);
            
            long yMaxSquare = r2Square - xSquare;
            long yMinSquare = r1Square - xSquare > 0 ? r1Square - xSquare : 0;
            
            long yMax = findYMax(yMaxSquare, r2);
            long yMin = findYMin(yMinSquare, r2);

            count += (long) (yMax - yMin + 1);
        }
        
        return count * 4;
    }
    int findYMax(long yMaxSquare, int r2) {
        for (int i = r2; i > 0; i--) {
            long iSquare = i*i;
            if (yMaxSquare >= iSquare) {
                return i;
            }
        }
        return 0;
    }
    int findYMin(long yMinSquare, int r2) {
        for (int i = 0; i < r2; i++) {
            long iSquare = i*i;
            if (yMinSquare <= iSquare) {
                return i;
            }
        }
        return r2;
    }

    /*
     * (FAIL)
     * 형변환 추가!
     */
    public long solution7(int r1, int r2) {
        
        long count = 0;
        long r1Square = r1 * r1;
        long r2Square = r2 * r2;
        
        for (int x = 1; x <= r2; x++) {
            long xSquare = ((long)x)*((long)x);
            
            long yMaxSquare = r2Square - xSquare;
            long yMinSquare = r1Square - xSquare > 0 ? r1Square - xSquare : 0;
            
            double yMax = Math.sqrt(yMaxSquare);
            double yMin = Math.sqrt(yMinSquare);
            
            count += (long) (Math.floor(yMax) - Math.ceil(yMin) + 1);
        }
        
        return count * 4;
    }

    /*
     * (FAIL)
     */
    public long solution6(int r1, int r2) {
        
        long count = 0;
        long r1Square = r1 * r1;
        long r2Square = r2 * r2;
        
        for (int x = 1; x <= r2; x++) {
            double yMax = Math.floor(Math.sqrt(r2Square - x*x));
            double yMin = r1Square - x*x > 0 ? Math.ceil(Math.sqrt(r1Square - x*x)) : 0;
            
            count += yMax - yMin + 1;
        }
        
        return count * 4;
    }

    /*
     * (FAIL)
     * 네 번째 시도: y축 길이로 찾아보기
     */
    public long solution5(int r1, int r2) {
        
        long count = r2 - r1 + 1L;
        long r1Square = r1 * r1;
        long r2Square = r2 * r2;
        
        double yOfR1;
        
        for (int x = 1; x < r2; x++) {
            double yOfR2 = Math.sqrt(r2Square - x*x);
            if (r1 < x) yOfR1 = 0.0;
            else yOfR1 = Math.sqrt(r1Square - x*x);
            
            if (yOfR1 == 0.0) { yOfR1 = 0.9; }

            count += Math.floor(yOfR2) - Math.ceil(yOfR1) + 1;
        }
        
        return count * 4;
    }

    /*
     * (FAIL)
     * 세 번째 시도: 로직 단순화
     */
    public long solution4(int r1, int r2) {
        
        long count = r2 - r1 + 1L;
        long r1Square = r1 * r1;
        long r2Square = r2 * r2;
        
        for (int x = 1; x < r2; x++) {
            for (int y = 1; y < r2; y++) {
                long ySquare = x*x + y*y;
                if (ySquare >= r1Square && ySquare <= r2Square) { ++count; }
            }
        }
        
        return count * 4;
    }

    /* 
     * (FAIL)
     * BigDecimal로 수정
     */
    public long solution3(int r1, int r2) {
        
        long count = r2 - r1 + 1L;
        BigDecimal r1Square = BigDecimal.valueOf(r1 * r1);
        BigDecimal r2Square = BigDecimal.valueOf(r2 * r2);
        
        for (int x = 1; x < r2; x++) {
            int topY = r2 - 1;
            int bottomY = 1;
            
            BigDecimal targetTop = BigDecimal.valueOf(x*x + topY*topY);
            BigDecimal targetBottom = BigDecimal.valueOf(x*x + bottomY*bottomY);
            
            while (targetTop.compareTo(r2Square) > 0) {
                --topY;
                targetTop = BigDecimal.valueOf(x*x + topY*topY);
            }
            while (targetBottom.compareTo(r1Square) < 0) {
                ++bottomY;
                targetBottom = BigDecimal.valueOf(x*x + bottomY*bottomY);
            }
            
            count += topY - bottomY + 1;
        }
        
        return count * 4;
    }

    /*
     * (FAIL)
     * 두 번째 시도: 일부 통과
     */
    public long solution2(int r1, int r2) {
        
        long count = r2 - r1 + 1L;
        long r1Square = r1 * r1;
        long r2Square = r2 * r2;
        
        for (int x = 1; x < r2; x++) {
            int topY = r2 - 1;
            int bottomY = 1;
            
            long targetTop = x*x + topY*topY;
            long targetBottom = x*x + bottomY*bottomY;
            
            while (targetTop > r2Square) {
                --topY;
                targetTop = x*x + topY*topY;
            }
            while (targetBottom < r1Square) {
                ++bottomY;
                targetBottom = x*x + bottomY*bottomY;
            }
            
            count += topY - bottomY + 1;
        }
        
        return count * 4;
    }
    
    /*
     * (FAIL)
     * 최초로 푼 내용: 잘못된 로직
     */
    public long solution1(int r1, int r2) {
        
        long count = r2 - r1 + 1L;
        long r1Square = r1 * r1;
        long r2Square = r2 * r2;
        
        for (int x = 1; x <= r2 - 1; x++) {
            for (int y = r2 - 1; y >= 1; y--) {
                long temp = x * x + y * y;
                if (temp > r1Square && temp < r2Square) { ++count; }
                else {continue;}
            }
        }
        
        return count * 4;
    }

}
