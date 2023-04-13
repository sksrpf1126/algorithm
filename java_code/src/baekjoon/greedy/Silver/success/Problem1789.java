package baekjoon.greedy.Silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 실버 5
 * 수들의 합
 */
public class Problem1789 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        int count = 1;

        while (true) {
            if(S - count > 0) {
                S -= count;
                count++;
            }else if(S - count == 0) {
                count++;
                break;
            }else {
                break;
            }
        }

        System.out.println(count - 1);
        
        br.close();
    }
}
