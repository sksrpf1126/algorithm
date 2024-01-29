package baekjoon.greedy.gold.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1911 {
    public static int N, L;

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        int[][] array = new int[N][2];

        for(int i = 0; i < array.length; i++) {
            st = new StringTokenizer(br.readLine());
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array, (o1, o2) -> {
            if(o1[0] == o2[0]) return o1[1] - o2[1];

            return o1[0] -o2[0];
        });

        int range = 0, answer = 0;

        for(int[] arr : array) {
            if(arr[0] > range) range = arr[0];

            if(arr[1] > range) {
                while(arr[1] > range) {
                    range += L;
                    answer++;
                }
            }
        }

        br.close();
    }
}
}
