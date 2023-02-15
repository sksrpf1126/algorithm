package baekjoon.bruteforce.silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 실버 3
 * N과 M (2)
 */
public class Problem15650 {

    public static int[] numbers;
    public static int[] permutationNumbers;
    public static int M;


    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sToken = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(sToken.nextToken());
        M = Integer.parseInt(sToken.nextToken());

        numbers = new int[N];
        permutationNumbers = new int[M];

        for(int i = 1; i <= N; i++) {
            numbers[i - 1] = i;
        }

        combination(0, 0);

    }

    public static void combination(int idx, int start) {

        if(idx == M) {
            for (int value : permutationNumbers) {
                System.out.print(value + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i < numbers.length; i++) {
            permutationNumbers[idx] = numbers[i];
            combination(idx + 1, i);
        }
    }
}
