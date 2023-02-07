package baekjoon.greedy.bronze.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 브론즈 2
 * 피로도
 */
public class Problem22864 {
    public static void main(String[] args) throws IOException {
        solution();

    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sToken = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(sToken.nextToken()); //일한 시간당 피로도
        int B = Integer.parseInt(sToken.nextToken()); //일 처리량
        int C = Integer.parseInt(sToken.nextToken()); //휴식 시간당 피로도 감소
        int M = Integer.parseInt(sToken.nextToken()); //피로도 한계치

        int P = 0; //현재 피로도
        int workHour = 0; //일한 시간

        if(A > M) {
            System.out.println(0);
            return;
        }

        for(int i = 0; i < 24; i++) {
            
            if(P + A <= M) {
                //일을 할 수 잇는 경우
                workHour++;
                P += A;
            }else {
                //휴식을 취해야 하는 경우
                P = P - C >= 0 ? P - C : 0;
            }
        }

        sb.append(B * workHour);

        System.out.println(sb);

        br.close();
    }
}
