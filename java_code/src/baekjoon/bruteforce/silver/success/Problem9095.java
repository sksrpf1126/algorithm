package baekjoon.bruteforce.silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 실버 3
 * 1, 2, 3 더하기
 */
public class Problem9095 {

    public static int answer;
    public static int N;
    public static int[] numbers = new int[]{1,2,3};

    public static void main(String[] args) throws IOException {
        solution();

    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            answer = 0;

            for(int j = 1; j <= N; j++) {
                duplicatePermutation(j,0,0);
            }

            System.out.println(answer);
        }

        }

        public static void duplicatePermutation(int count, int idx, int sum) {

        if(sum > N) {
            return;
        }

        if(idx == count) {
            if(sum == N) {
                answer++;
            }
            return;
        }

        for(int i = 0; i < numbers.length; i++) {
            duplicatePermutation(count, idx+1, sum + numbers[i]);
        }

        }
}
