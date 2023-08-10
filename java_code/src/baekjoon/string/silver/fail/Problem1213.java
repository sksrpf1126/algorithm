package baekjoon.string.silver.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 실버 3
 * 팰린드롬 만들기
 */
public class Problem1213 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = br.readLine();

        int[] alpha = new int[26];

        /**
         * 단어에 존재하는 알파벳의 수를 배열에 카운팅
         */
        for(int i = 0; i < words.length(); i++) {
            alpha[words.charAt(i) - 'A']++;
        }

        int odd = 0; //홀수개의 알파벳 수
        int center = 0;

        for(int i = 0; i < alpha.length; i++) {
            if(alpha[i] % 2 != 0) {
                center = i; //1개의 갯수를 가진 알파벳 저장
                odd++;
            }
        }

        /**
         * 홀수개를 가진 알파벳이 1개를 넘는다면 만들기 불가능
         * 또는
         * 홀수개를 가진 알파벳이 1개이지만 짝수의 길이를 가진다면 불가능
         */
        if(odd > 1 || (odd == 1 && words.length() % 2 == 0)) {
            System.out.println("I`m Sorry Hansoo");
        }

        StringBuilder sb = new StringBuilder();

        /**
         * 팰린드롬 만들기
         * 알파벳 하나씩만 사용해서 만든 후 해당 단어를 뒤집어서 이어 붙이면 된다.
         */
        for(int i = 0; i < alpha.length; i++) {
            for(int j = 0; j < alpha[i] / 2; j++) {
                sb.append((char)(i + 'A'));
            }
        }

        StringBuilder tmp = new StringBuilder(sb);

        if(odd == 1) {
            sb.append((char)(center + 'A'));
        }

        System.out.println(sb.toString() + tmp.reverse());

        br.close();
    }

}

