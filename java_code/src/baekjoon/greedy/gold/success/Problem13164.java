package baekjoon.greedy.gold.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 골드 5
 * 행복 유치원
 *
 * 센서 문제와 동일한 해결방법이어서 쉽게 접근해서 풀었다.
 */
public class Problem13164 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sToken = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(sToken.nextToken());
        int K = Integer.parseInt(sToken.nextToken());
        sToken = new StringTokenizer(br.readLine());
        Integer[] student = new Integer[N];
        Integer[] diff = new Integer[N-1];
        Integer answer = 0;

        //센서 좌표 배열 넣기
        for(int i = 0; sToken.hasMoreTokens(); i++) {
            student[i] = Integer.parseInt(sToken.nextToken());
        }

        for(int i = 1; i < student.length; i++) {
            diff[i-1] = student[i] - student[i-1];
        }

        Arrays.sort(diff);

        for(int i = 0; i < diff.length - (K - 1); i++) {
            answer += diff[i];
        }

        System.out.println(answer);

        br.close();
    }
}
