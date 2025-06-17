package codility.contest2017;

import java.util.*;

/*
 * Codility: Medium Level
 * https://app.codility.com/programmers/trainings/3/socks_laundering/
 */
public class SocksLaundering {

    /*
     * Score: 80%
     * https://app.codility.com/demo/results/training549U8A-KE7/
     */
    public class SocksLaundering2 {
        public int solution(int K, int[] C, int[] D) {

            Map<Integer, Integer> cleanSocks = new HashMap<>();
            Map<Integer, Integer> dirtySocks = new HashMap<>();

            makeSockMap(C, cleanSocks);
            makeSockMap(D, dirtySocks);

            int curK = calculateOnlyOneSocks(cleanSocks, dirtySocks, K);
            if (curK > 0) {
                calculatePairSocks(cleanSocks, dirtySocks, curK);
            }

            return calculateResult(cleanSocks);
        }

        void makeSockMap(int[] arr, Map<Integer, Integer> map) {
            for (int a : arr) {
                Integer o = Integer.valueOf(a);
                if (map.containsKey(o)) {
                    map.put(o, map.get(o) + 1);
                } else {
                    map.put(o, 1);
                }
            }
        }

        int calculateResult(Map<Integer, Integer> cleanSocks) {
            int num = 0;
            Set<Integer> cleanSocksKeys = cleanSocks.keySet();
            for (int key : cleanSocksKeys) {
                num += cleanSocks.get(key) / 2;
            }
            return num;
        }

        int calculateOnlyOneSocks(
            Map<Integer, Integer> cleanSocks, Map<Integer, Integer> dirtySocks, int K
        ) {
            Iterator<Map.Entry<Integer, Integer>> iterator = dirtySocks.entrySet().iterator();

            while (iterator.hasNext()) {
                if (K == 0) {return K;}

                Map.Entry<Integer, Integer> entry = iterator.next();
                Integer key = entry.getKey();
                
                Integer curCleanSock = cleanSocks.get(key) == null ? 0 : cleanSocks.get(key);
                Integer curDirtySock = dirtySocks.get(key);

                if (curCleanSock % 2 == 1) {
                    cleanSocks.put(key, curCleanSock + 1);
                    dirtySocks.put(key, curDirtySock - 1);

                    if (curDirtySock - 1 == 0) {iterator.remove();}

                    --K;
                }
            }

            return K;
        }

        void calculatePairSocks(
            Map<Integer, Integer> cleanSocks, Map<Integer, Integer> dirtySocks, int K
        ) {
            Set<Integer> keys = dirtySocks.keySet();

            for (Integer key : keys) {
                if (K < 2) {return;}

                Integer curCleanSocks = cleanSocks.get(key) == null ? 0 : cleanSocks.get(key);
                Integer curDirySocks = dirtySocks.get(key);

                if (curCleanSocks % 2 == 1) {
                    if (curDirySocks % 2 == 0) {--curDirySocks;}
                } else {
                    if (curDirySocks < 2) {continue;}
                }

                if (K <= curDirySocks) {
                    cleanSocks.put(key, curCleanSocks + K);
                    return;
                } else {
                    cleanSocks.put(key, curCleanSocks + curDirySocks);
                    K -= curDirySocks;
                }
            }
        }
    }

    /*
     * score: 50%
     * https://app.codility.com/demo/results/trainingMNRP4P-BR7/
     */
    public class SocksLaundering1 {
        public int solution(int K, int[] C, int[] D) {
    
            Map<Integer, Integer> cleanMap = new HashMap<>();
            Map<Integer, Integer> dirtyMap = new HashMap<>();
    
            makeMap(cleanMap, C);
            makeMap(dirtyMap, D);
    
            Set<Integer> keys = cleanMap.keySet();
            for (Integer key : keys) {
                if (K == 0) {break;}
    
                int curValue = cleanMap.get(key);
                if (curValue % 2 == 1) {
                    Integer dirtyValue = dirtyMap.get(key);
                    if (dirtyValue != null && dirtyValue > 0) {
                        --K;
                        cleanMap.put(key, curValue + 1);
                        dirtyMap.put(key, dirtyValue - 1);
                    }
                }
            }
    
            if (K >= 2) {
                Set<Integer> dirtyKeys = dirtyMap.keySet();
                for (Integer key : dirtyKeys) {
                    Integer curValue = dirtyMap.get(key);
                    if (curValue >= 2) {
                        K -= 2;
                        dirtyMap.put(key, curValue - 2);
                        cleanMap.put(key, cleanMap.get(key) + 2);
                    }
                    if (K < 2) { break; }
                }
            }
    
            int ans = 0;
            for (Integer key : keys) {
                int curValue = cleanMap.get(key);
                ans += curValue / 2;
            }
            return ans;
        }
    
        void makeMap(Map<Integer, Integer> map, int[] arr) {
            for (int o : arr) {
                if (map.containsKey(o)) {
                    int curCount = map.get(o);
                    map.put(o, curCount + 1);
                } else {
                    map.put(o, 1);
                }
            }
        }
    }
    

}
