package baekjoon.bruteforce.silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 실버 2
 * 부분수열의 합
 */
public class Problem1182 {

    public static int answer = 0;
    public static int N;
    public static int S;
    public static int[] numbers;
    public static int[] permutationNumbers;

    public static void main(String[] args) throws IOException {
        solution();

    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        numbers = new int[N];

        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++) {
            permutationNumbers = new int[i];
            permutation(i,0,0);
        }

        System.out.println(answer);

    }

    public static void permutation(int cnt, int idx, int start) {
        if(idx == cnt) {
            int sum = 0;
            for (int i : permutationNumbers) {
                sum += i;
            }
            if(S == sum) answer++;
            return;
        }

        for(int i = start; i < numbers.length; i++) {

            permutationNumbers[idx] = numbers[i];
            permutation(cnt, idx + 1, i + 1);
        }
    }

}
