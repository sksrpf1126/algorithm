package baekjoon.bruteforce.silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 실버 3
 * 퇴사
 */
public class Problem14501 {
    public static int N;
    public static int[][] days;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        solution();

    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        days = new int[N+1][2];

        StringTokenizer sToken;

        //1부터 접근
        for(int i = 1; i <= N; i++) {
            sToken = new StringTokenizer(br.readLine());
            days[i][0] = Integer.parseInt(sToken.nextToken());
            days[i][1] = Integer.parseInt(sToken.nextToken());
        }

        for(int i = 1; i <= N; i++) {
            daysCombination(i,0);
        }

        System.out.println(answer);


    }

    public static void daysCombination(int startDay, int sum) {

        if(startDay >= days.length) {
            answer = Math.max(answer, sum);
            return;
        }

        if(startDay + days[startDay][0] > N + 1) {
            answer = Math.max(answer, sum);
            return;
        }

        for(int i = 0; i <= N; i++) {
            sum += days[startDay][1];
            daysCombination(startDay + i + days[startDay][0], sum);
            sum -= days[startDay][1];
        }

    }

}
