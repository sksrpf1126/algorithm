package baekjoon.bruteforce.silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 실버 2
 * 차이를 최대로
 */
public class Problem10819 {

    public static int[] numbers;
    public static int[] permutationNumbers;
    public static boolean[] checkNumbers;
    public static int N;
    public static int answer = 0;


    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer sToken = new StringTokenizer(br.readLine());

        numbers = new int[N];
        checkNumbers = new boolean[N];
        permutationNumbers = new int[N];

        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(sToken.nextToken());
        }

        permutation(0);

        System.out.println(answer);
    }

    public static void permutation(int idx) {

        if(idx == N) {
            int diffValue = 0;
            for(int i = 0; i+1 < permutationNumbers.length; i++) {
                diffValue += Math.abs(permutationNumbers[i] - permutationNumbers[i + 1]);
            }
            if(diffValue > answer) {
                answer = diffValue;
            }
            return;
        }

        for(int i = 0; i < numbers.length; i++) {
            if(checkNumbers[i]) continue;

            permutationNumbers[idx] = numbers[i];
            checkNumbers[i] = true;
            permutation(idx + 1);
            checkNumbers[i] = false;
        }
    }
}
