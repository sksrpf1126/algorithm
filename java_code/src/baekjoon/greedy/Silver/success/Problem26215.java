package baekjoon.greedy.Silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 실버 3
 * 눈 치우기
 */
public class Problem26215 {
    public static void main(String[] args) throws IOException {
        solution();

    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        StringTokenizer sToken = new StringTokenizer(br.readLine());
        int[] snowAmount = new int[input];
        int answer = 0;
        int lastIdx = snowAmount.length - 1;

        for(int i = 0; i < snowAmount.length; i++) {
            snowAmount[i] = Integer.parseInt(sToken.nextToken());
        }

        Arrays.sort(snowAmount);

        while(answer <= 1440 && snowAmount[lastIdx] != 0) {

            if(lastIdx != 0 && snowAmount[lastIdx - 1] != 0) {
                snowAmount[lastIdx - 1] -= 1;
                snowAmount[lastIdx] -= 1;
                answer++;
                Arrays.sort(snowAmount);
            }else {
                answer += snowAmount[lastIdx];
                break;
            }
        }

        if(answer > 1440) {
            System.out.println(-1);
        }else {
            System.out.println(answer);
        }


        br.close();
    }
}
