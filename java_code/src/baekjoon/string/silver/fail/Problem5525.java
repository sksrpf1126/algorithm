package baekjoon.string.silver.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 실버 1
 * IOIOI
 * 
 * 시간 초과가 발생하여 부분적으로 맞춘 문제
 * KMP 알고리즘을 적용하여 해결하였음
 */
public class Problem5525 {

    public static int[] pi;

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        StringBuilder pn = new StringBuilder("I");
        int answer = 0;

        for(int i = 0; i < N; i++) {
            pn.append("OI");
        }

        pi = new int[pn.length()];
        getPi(pn.toString());

        int j = 0;
        for(int i = 0; i < S.length(); i++) {

            while (j > 0 && pn.charAt(j) != S.charAt(i)) {
                j = pi[j-1];
            }

            if(pn.charAt(j) == S.charAt(i)) {
                if(j == pn.length() - 1) {
                    answer++;
                    j = pi[j];
                }else {
                    j++;
                }
            }
        }

        System.out.println(answer);

        br.close();
    }

    public static void getPi(String pattern) {
        int j = 0;
        for(int i = 1; i < pattern.length(); i++) {

            while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
                j = pi[j-1];
            }

            if(pattern.charAt(j) == pattern.charAt(i)) pi[i] = ++j;
        }
    }

}

