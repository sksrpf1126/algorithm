package baekjoon.bruteforce.silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 실버 2
 * 로또
 */
public class Problem6603 {
    public static int K;
    public static int[] numbers;
    public static int[] choiceNumbers;

    public static void main(String[] args) throws IOException {
        solution();

    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sToken;

        while (true) {
            sToken = new StringTokenizer(br.readLine());

            K = Integer.parseInt(sToken.nextToken());

            if(K == 0) break;

            numbers = new int[K];
            choiceNumbers = new int[6];

            for(int i = 0; i < K; i++) {
                numbers[i] = Integer.parseInt(sToken.nextToken());
            }

            combination(0,0);
            System.out.println();

        }

    }

    public static void combination(int idx, int start) {
        if(idx == 6) {
            for (int number : choiceNumbers) {
                System.out.print(number + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i < numbers.length; i++) {
            choiceNumbers[idx] = numbers[i];
            combination(idx + 1, i + 1);
        }
    }
}
