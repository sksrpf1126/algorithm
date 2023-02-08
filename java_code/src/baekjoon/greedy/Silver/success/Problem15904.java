package baekjoon.greedy.Silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 실버 5
 * UCPC는 무엇의 약자일까?
 */
public class Problem15904 {
    public static void main(String[] args) throws IOException {
        solution();

    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] UCPC = new char[]{'U','C','P','C'};
        String input = br.readLine();
        int check = 0;

        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c == UCPC[check]) {
                check++;
                if(check == UCPC.length) {
                    break;
                }
            }
        }

        if(check == UCPC.length) {
            System.out.println("I love UCPC");
        }else {
            System.out.println("I hate UCPC");
        }

        br.close();
    }
}
