package baekjoon.bruteforce.silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 실버 2
 * 스타트와 링크
 * 더 깔끔한 방법
 *
 * https://st-lab.tistory.com/122 참고
 *
 *
 */
public class Problem14889V2 {
    public static int N;
    public static int[][] statusMap;
    public static int answer = Integer.MAX_VALUE;
    public static boolean[] visits;

    public static void main(String[] args) throws IOException {
        solution();

    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        statusMap = new int[N][N];
        visits = new boolean[N];

        StringTokenizer sToken;

        //1부터 접근
        for(int i = 0; i < N; i++) {
            sToken = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                statusMap[i][j] = Integer.parseInt(sToken.nextToken());
            }
        }

        teamCombination(0,0);

        System.out.println(answer);


    }

    public static void teamCombination(int idx, int start) {
        if(idx == N / 2) {
            diff();
            return;
        }

        for(int i = start; i < N; i++) {

            if(!visits[i]) {
                visits[i] = true;
                teamCombination(idx + 1, i + 1);
                visits[i] = false;
            }
        }
    }

    public static void diff() {
        int teamAstatus = 0;
        int teamBstatus = 0;

        for(int i = 0; i < N -1; i++) {
            for(int j = i + 1; j < N; j++) {
                if(visits[i] == true && visits[j] == true) {
                    teamAstatus += statusMap[i][j];
                    teamAstatus += statusMap[j][i];
                }else if(visits[i] == false && visits[j] == false) {
                    teamBstatus += statusMap[i][j];
                    teamBstatus += statusMap[j][i];
                }
            }
        }

        int value = Math.abs(teamAstatus - teamBstatus);

        //0이라면 제일 작은 값이므로, exit(0)을 통해 종료.
        if(value == 0) {
            System.out.println(value);
            System.exit(0);
        }

        answer = Math.min(answer, value);

    }
}
