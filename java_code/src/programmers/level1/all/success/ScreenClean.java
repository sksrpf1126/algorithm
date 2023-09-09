package programmers.level1.all.success;

import java.util.Arrays;

/**
 * level 1
 * 바탕화면 정리
 */
public class ScreenClean {

    public static void main(String[] args) {
        solution(new String[]{"..........", ".....#....", "......##..", "...##.....", "....#....."});
    }

    public static void solution(String[] wallpaper) {
        int[] answer = new int[4];
        int up = 0, left = Integer.MAX_VALUE, down = 0, right = 0;

        for(int i = 0; i < wallpaper.length; i++) {
            for(int j = 0; j < wallpaper[i].length(); j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    if(up == 0) up = i;
                    if(left > j) left = j;
                    if(down < i + 1) down = i + 1;
                    if(right < j + 1) right = j + 1;
                }
            }
        }

        answer[0] = up;
        answer[1] = left;
        answer[2] = down;
        answer[3] = right;

        System.out.println(Arrays.toString(answer));

    }

}
