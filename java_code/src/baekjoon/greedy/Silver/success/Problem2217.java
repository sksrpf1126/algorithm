package baekjoon.greedy.Silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 실버 4
 * 로프
 */
public class Problem2217 {
    public static void main(String[] args) throws IOException {
        solution();

    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ropes = Integer.parseInt(br.readLine());
        int[] weights = new int[ropes];

        for(int i = 0; i < ropes; i++) {
            weights[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(weights);
        int count = 0; //로프 수
        int answer = 0;
        
        for(int i = weights.length -1; i >= 0; i--) {
            count++;
            answer = Math.max(weights[i] * count, answer);
        }

        System.out.println(answer);
        
        br.close();
    }
}
