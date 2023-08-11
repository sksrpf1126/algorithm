package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문자열에 특정 단어가 존재하는지 판단하는 알고리즘(KMP)으로
 * M길이의 문자열과 N길이의 단어가 있을 때
 * O(M+N) 의 시간복잡도를 가진다.
 * https://devje8.tistory.com/24 참고
 */
public class KMP {

    public static int[] pi;
    public static String origin, pattern;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        origin = br.readLine();
        pattern = br.readLine();
        pi = new int[pattern.length()];

        getPi();
        kmp_solution();

        br.close();
    }

    public static void getPi() {
        int j = 0;

        for(int i = 1; i < pattern.length(); i++) {

            while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
                j = pi[j-1];
            }

            if(pattern.charAt(j) == pattern.charAt(i)) {
                pi[i] = ++j;
            }
        }
    }

    public static void kmp_solution() {
        int j = 0;
        int flag = 0;

        for(int i = 0; i < origin.length(); i++) {

            while (j > 0 && origin.charAt(i) != pattern.charAt(j)) {
                j = pi[j-1];
            }

            if(origin.charAt(i) == pattern.charAt(j)) {
                if(j == pattern.length() - 1) {
                    flag = 1;
                    break;
                }else {
                    j++;
                }
            }
        }

        System.out.println(flag);

    }


}
