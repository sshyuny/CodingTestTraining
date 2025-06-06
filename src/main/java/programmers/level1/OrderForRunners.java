package programmers.level1;

import java.util.*;

/**
 * Lv.1
 * 달리기 경주
 * https://school.programmers.co.kr/learn/courses/30/lessons/178871
 */
class OrderForRunners {

    String[] solution(String[] players, String[] callings) {

        int playersNum = players.length;

        // player, 등수
        Map<String, Integer> nameOrderMap = new HashMap<>();
        // 등수, player
        Map<Integer, String> orderNameMap = new HashMap<>();

        for (int i = 0; i < playersNum; i++) {
            nameOrderMap.put(players[i], i);
            orderNameMap.put(i, players[i]);
        }

        for (String calling : callings) {
            int order = nameOrderMap.get(calling);
            String beforeName = orderNameMap.get(order - 1);
            nameOrderMap.put(calling, order - 1);
            nameOrderMap.put(beforeName, order);
            orderNameMap.put(order - 1, calling);
            orderNameMap.put(order, beforeName);
        }

        String[] answer = new String[playersNum];
        for (int i = 0; i < playersNum; i++) {
            answer[i] = orderNameMap.get(i);
        }
        return answer;
    }
    
}