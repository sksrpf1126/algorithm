package baekjoon.greedy.Silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 초콜릿 식사
 */
public class Problem2885 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        int chocolate = 1;

        while(chocolate < K) {
            chocolate *= 2;
        }

        int current = chocolate;
        int answer = 0;

        while(K > 0) {
            if(current <= K) K -= current;
            else {
                current /= 2;
                answer++;
            }
        }

        System.out.println(chocolate +" " + answer);

        br.close();
    }
}
