package codility.contest2017;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * Codility: Medium Level
 * https://app.codility.com/programmers/trainings/3/socks_laundering/
 */
public class SocksLaundering {

    /*
     * score: 50%
     * https://app.codility.com/demo/results/trainingMNRP4P-BR7/
     */
    class SocksLaundering1 {
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
