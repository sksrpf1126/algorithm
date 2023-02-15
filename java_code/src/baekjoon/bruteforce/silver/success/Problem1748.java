package baekjoon.bruteforce.silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 실버 4
 * 수 이어 쓰기 1
 * 시간제한이 0.15초이다. 즉, 수학적으로 접근해서 풀어야 함
 */
public class Problem1748 {

    public static void main(String[] args) throws IOException {
        solution();

    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String stringN = br.readLine();
        int len = stringN.length();
        int N = Integer.parseInt(stringN);
        long answer = 0;

        for(int i = 1; i <= len; i++) {
            if(i < len) {
                answer += 9 * (long)Math.pow(10, i-1) * i;
            }else {
                answer += (N - (long)Math.pow(10, i-1) + 1) * len;
            }
        }

        System.out.println(answer);

    }
}
