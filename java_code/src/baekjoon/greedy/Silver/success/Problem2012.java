package baekjoon.greedy.Silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 실버 3
 * 등수 매기기
 */
public class Problem2012 {

    public static int N;

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] rank = new int[500001];

        for(int i = 1; i < N + 1; i++) {
            int number = Integer.parseInt(br.readLine());
            rank[number] = rank[number] + 1;
        }

        int current = 1;
        long answer = 0;

        for(int i = 1; i < 500001; i++) {
            int count = rank[i];

            for(int j = 0; j < count; j++) {
                answer += Math.abs(i - current);
                current++;
            }
        }

        System.out.println(answer);
        
        br.close();
    }
}
