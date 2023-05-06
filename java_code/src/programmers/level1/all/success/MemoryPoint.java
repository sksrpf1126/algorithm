package programmers.level1.all.success;

import java.util.HashMap;
import java.util.Map;

/**
 * level 2
 * 전력망을 둘로 나누기
 */
public class MemoryPoint {

    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
        int[] answer = new int[photo.length];

        Map<String, Integer> pointMap = new HashMap<>();

        for(int i = 0; i < name.length; i++) {
            pointMap.put(name[i], yearning[i]);
        }

        for(int i = 0; i < photo.length; i++) {
            int total = 0;
            for(int j = 0; j < photo[i].length; j++) {
                if(pointMap.containsKey(photo[i][j])) {
                    total += pointMap.get(photo[i][j]);
                }
            }
            answer[i] = total;
        }

        for (int i : answer) {
            System.out.println(i);
        }


    }

}
