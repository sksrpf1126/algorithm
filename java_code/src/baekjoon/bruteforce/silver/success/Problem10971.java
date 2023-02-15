package baekjoon.bruteforce.silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 실버 2
 * 외판원 순회2
 */
public class Problem10971 {

    public static int[][] cityDistance;
    public static int[] permutationDistance;
    public static boolean[] visits;
    public static int N;
    public static int answer = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer sToken;

        cityDistance = new int[N][N];
        visits = new boolean[N];
        permutationDistance = new int[N];

        for(int i = 0; i < N; i++) {
            sToken = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                cityDistance[i][j] = Integer.parseInt(sToken.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            visits[i] = true;
            permutationCity(i,0,i);
            visits[i] = false;
        }

        System.out.println(answer);
    }

    public static void permutationCity(int startCityIdx, int cnt, int lastCityIdx) {

        if(cnt+1 == N) {
            int sum = 0;
            permutationDistance[startCityIdx] = cityDistance[startCityIdx][lastCityIdx];

            for(int i = 0; i < permutationDistance.length; i++) {
                sum += permutationDistance[i];
                System.out.print(permutationDistance[i] + " ");
            }
            System.out.println();
            if(sum < answer && permutationDistance[startCityIdx] != 0) {
                answer = sum;
            }
//            visits[startCityIdx] = false;
            return;
        }

        //현 도시를 방문처리를 먼저해야 이후에 같은 도시를 또 순회하지 않음.


        for(int i = 0; i < N; i++) {
            if(visits[i] || startCityIdx == i) continue;
            if(cityDistance[startCityIdx][i] == 0) continue;

            visits[startCityIdx] = true;
            permutationDistance[startCityIdx] = cityDistance[startCityIdx][i];
            permutationCity(i,cnt+1,lastCityIdx);
            visits[startCityIdx] = false;
        }
    }

}
