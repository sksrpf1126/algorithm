package programmers.level1.all.success;

import java.util.HashMap;
import java.util.Map;

public class Marathon {

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        Map<String, Integer> playersMap = new HashMap<>();

        for(int i = 0; i < players.length; i++) {
            playersMap.put(players[i], i);
        }

        for(String calling : callings) {
            int idx = playersMap.get(calling);
            String frontPlayer = players[idx - 1];
            players[idx -1] = players[idx];
            players[idx] = frontPlayer;

            playersMap.put(calling, idx - 1);
            playersMap.put(frontPlayer, idx);
        }


    }

}
