package programmers.level1.all.success;

import java.util.ArrayList;
import java.util.List;

/**
 * level 1
 * 덧칠하기
 */
public class Paint {

    public static void main(String[] args) {
        solution(8, 4, new int[]{2,3,6});
        solution(5, 4, new int[]{1,3});
        solution(4, 1, new int[]{1,2,3,4});
    }

    public static void solution(int n, int m, int[] section) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();

        for(int i : section) {
            list.add(i);
        }

        while (list.size() > 0) {
            Integer left = list.get(0);
            Integer right = left + m - 1;

            if(right > n) {
                left = left - (right - n);
            }

            for(Integer i = left; i < left + m; i++) {
                list.remove(i);
            }
            answer++;

        }

        System.out.println("answer : " + answer);
    }

}
