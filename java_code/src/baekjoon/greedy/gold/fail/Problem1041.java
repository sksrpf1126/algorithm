package baekjoon.greedy.gold.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 골드 5
 * 주사위(실패, 백준에 실패로 남겨둠)
 *
 * 1개가 보이는 주사위의 수, 2개가 보이는 주사위의 수, 3개가 보이는 주사위의 수의 점화식은 찾았지만
 * 2개가 보이는 주사위 중 최솟값, 3개가 보이는 주사위 중 최솟값을 찾지 못하였음.
 *
 * https://velog.io/@zayson/BOJ-1041%EB%B2%88-%EC%A3%BC%EC%82%AC%EC%9C%84 를 참고해서 이해하고 다시 풀이하였음
 * 
 */
public class Problem1041 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(br.readLine());
        StringTokenizer sToken = new StringTokenizer(br.readLine());
        Integer[] dice = new Integer[6];

        for(int i = 0; sToken.hasMoreTokens(); i++){
            dice[i] = Integer.valueOf(sToken.nextToken());
        }

        if(N == 1) {
            Arrays.sort(dice);
            int sum = 0;
            for(int i = 0 ; i < 5; i++) {
                sum += dice[i];
            }
            System.out.println(sum);
            return;
        }

        long AandF = Math.min(dice[0], dice[5]);
        long BandE = Math.min(dice[1], dice[4]);
        long CandD = Math.min(dice[2], dice[3]);

        long one = Math.min(AandF, Math.min(BandE, CandD));
        long two = Math.min(AandF + BandE, Math.min(AandF + CandD, BandE + CandD));
        long three = AandF + BandE + CandD;

        long answer = 0;

        answer += three * 4; //세 면이 보이는 주사위는 4개
        answer += two * ((N - 1) * 4 + (N - 2) * 4); //두 면의 최소값 * 두 면이 보이는 주사위 수
        //하나의 면이 보이는 주사위의 수는
        //(5개의 총 면 수) - (2개의 면이 보이는 주사위 수의 총 면 수) - (3개의 면이 보이는 주사위 수의 총 면 수) 이며,
        //이를 가장 작은 최솟값(one)을 곱하면 된다.
        answer += one * ((N * N * 5) - (2 * ((N -1) * 4 + (N - 2) * 4)) - (3 * 4));

        System.out.println(answer);

        br.close();
    }

}
