package codility.exercise7;

public class ArrListLen {

    /*
     * score: 100%
     * https://app.codility.com/demo/results/trainingAQDSPG-DGT/
     */
    class ArrListLenSolution1 {
        public int solution(int[] A) {
            int arrLength = A.length;
            int listLength = 0;
            int curIdx = 0;
    
            while (curIdx <= arrLength) {
                int value = A[curIdx];
                if (value == curIdx) return listLength;
                ++listLength;
                if (value == -1) return listLength;
                curIdx = value;
            }
    
            return listLength;
        }
    }
    
    // score: 0%
    // https://app.codility.com/demo/results/training2MVVMK-VQY/

}
