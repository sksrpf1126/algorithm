package programmers.level1.all.success;

import java.util.ArrayList;
import java.util.List;

/**
 * level 1
 * 대충 만든 자판
 */
public class Keyboard {

    public static int min, total;

    public static void main(String[] args) {
        solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD", "AABB"});
        solution(new String[]{"AA"}, new String[]{"B"});
        solution(new String[]{"AGZ", "BSSS"}, new String[]{"ASA", "BGZ"});
    }

    public static void solution(String[] keymap, String[] targets) {
        List<Integer> list = new ArrayList<>();

        for(String target : targets) {
            total = 0;

            while(target.length() > 0) {
                char firstChar = target.charAt(0);
                target = target.substring(1);
                min = Integer.MAX_VALUE;

                for(String key : keymap) {
                    int idx = key.indexOf(firstChar) + 1;
                    if(idx > 0) {
                        min = Math.min(min, idx);
                    }
                }

                if(min == Integer.MAX_VALUE) {
                    total = -1;
                    break;
                }

                total += min;

                while(target.indexOf(firstChar) != -1) {
                    total += min;
                    int idx = target.indexOf(firstChar);
                    target = target.substring(0, idx) + target.substring(idx + 1);
                }
            }

            list.add(total);
        }

        Integer[] answer = list.toArray(new Integer[list.size()]);

        System.out.println("answer : " + answer);
    }

}
