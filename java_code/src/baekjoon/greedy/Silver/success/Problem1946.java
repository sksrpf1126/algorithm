package baekjoon.greedy.Silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 실버 1
 * 신입 사원
 */
public class Problem1946 {
    public static void main(String[] args) throws IOException {
        solution();

    }


    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sToken;
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] ranking = new int[N][2];

            for(int j = 0; j < N; j++) {
                sToken = new StringTokenizer(br.readLine());
                ranking[j][0] = Integer.parseInt(sToken.nextToken());
                ranking[j][1] = Integer.parseInt(sToken.nextToken());
            }

            Arrays.sort(ranking, (int[] o1, int[] o2) -> {
                return o1[0] - o2[0];
            });

            int min = ranking[0][1];
            //서류 순위가 1등인 사람은 면접 순위를 비교하지 않아도 된다.
            //그렇기에 아레 for문도 첫번째 인덱스는 건너뛴다.
            int answer = 1;

            for(int j = 1; j < ranking.length; j++) {
                if(min > ranking[j][1]) {
                    min = ranking[j][1];
                    answer++;
                }
            }

            System.out.println(answer);

        }


        br.close();
    }
}
