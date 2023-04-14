package programmers.level3.greedy.success;

import java.util.Arrays;

/**
 * level 3
 * 단속카메라
 */
public class ControlCamera {

    public static int[][] routes = {{-20,-15}, {-20,-17}, {-18,-13}, {-5,-3}};

    public static void main(String[] args) {
        int answer = 0;

        Arrays.sort(routes, (int[] o1, int[] o2) -> {

            if(o1[0] == o2[0]) {
                return o1[0] - o2[0];
            }

            return o1[1] - o2[1];
        });

        int position = routes[0][1];
        answer++;

        for(int i = 1; i < routes.length; i++) {
            if(position < routes[i][0]) {
                answer++;
                position = routes[i][1];
            }
        }


        System.out.println(answer);
    }
}
