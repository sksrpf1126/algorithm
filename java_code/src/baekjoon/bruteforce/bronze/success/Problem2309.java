package baekjoon.bruteforce.bronze.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 브론즈 1
 * 일곱 난쟁이
 */
public class Problem2309 {

    public static Integer[] heights;
    public static int R = 7;
    public static Integer[] dwarf = new Integer[R];
    public static Integer[] answer = new Integer[R];

    public static void main(String[] args) throws IOException {
        solution();

    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        heights = new Integer[9];

        for(int i = 0; i < 9; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }

        combination(0,0);

        Arrays.sort(answer);

        for (int value : answer) {
            System.out.println(value);
        }

        br.close();
    }

    public static void combination(int cnt, int start) {

        if(cnt == R) {
            int sum = 0;
            for (int height : dwarf) {
                sum += height;
            }

            if(sum == 100) {
                 answer = dwarf.clone();
            }

            return;
        }

        for(int i = start; i < heights.length; i++) {
            dwarf[cnt] = heights[i];
            combination(cnt + 1, i + 1);
        }
    }
}
