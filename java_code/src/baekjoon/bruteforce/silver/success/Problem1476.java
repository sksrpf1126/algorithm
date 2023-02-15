package baekjoon.bruteforce.silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 실버 5
 * 날짜 계산
 */
public class Problem1476 {

    public static int[] ESM;

    public static void main(String[] args) throws IOException {
        solution();

    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sToken = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(sToken.nextToken());
        int S = Integer.parseInt(sToken.nextToken());
        int M = Integer.parseInt(sToken.nextToken());
        int answer = 0;

        ESM = new int[]{0,0,0};

        while (E != ESM[0] || S != ESM[1] || M != ESM[2]) {
            ESM[0] += 1;
            ESM[1] += 1;
            ESM[2] += 1;

            if(ESM[0] > 15) {
                ESM[0] = 1;
            }
            if(ESM[1] > 28) {
                ESM[1] = 1;
            }
            if(ESM[2] > 19) {
                ESM[2] = 1;
            }

            answer++;
        }

        System.out.println(answer);

    }
}
