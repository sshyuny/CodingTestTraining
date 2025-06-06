package codility.exercise7;

/*
 * Codility
 * Level: Medium
 * https://app.codility.com/programmers/trainings/7/tree_longest_zig_zag/
 */
public class TreeLongestZigZag {

    class Tree {
        public int x;
        public Tree l;
        public Tree r;
    }
    
    /*
     * score: 100%
     * https://app.codility.com/demo/results/trainingSCZXV5-9DR/
     */
    class TreeLongestZigZagSolution1 {
        
        public int solution(Tree T) {
            int ans = next(T, 3, 0);
            return ans;
        }

        // int 0 : left
        // int 1 : right
        int next(Tree curTree, int beforeDirection, int zigzagNum) {

            Tree nextLTree = curTree.l;
            Tree nextRTree = curTree.r;

            // 종료
            if (nextLTree == null && nextRTree == null) {
                return zigzagNum;
            }

            int maxZigzagNum = 0;

            // 각 경우 별 계산
            if (nextLTree != null) {
                if (beforeDirection == 1) {
                    int temp = next(nextLTree, 0, zigzagNum + 1);
                    maxZigzagNum = (temp > maxZigzagNum) ? temp : maxZigzagNum;
                } else {
                    int temp = next(nextLTree, 0, zigzagNum);
                    maxZigzagNum = (temp > maxZigzagNum) ? temp : maxZigzagNum;
                }
            }
            if (nextRTree != null) {
                if (beforeDirection == 0) {
                    int temp = next(nextRTree, 1, zigzagNum + 1);
                    maxZigzagNum = (temp > maxZigzagNum) ? temp : maxZigzagNum;
                } else {
                    int temp = next(nextRTree, 1, zigzagNum);
                    maxZigzagNum = (temp > maxZigzagNum) ? temp : maxZigzagNum;
                }
            }

            return maxZigzagNum;
        }
    }
}
