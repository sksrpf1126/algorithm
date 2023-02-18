package baekjoon.dfs.silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 실버 1
 * 단지번호붙이기
 */
public class Problem2667 {

    public static int[][] map;
    public static int[] dx = {-1, 0, 0, 1};
    public static int[] dy = {0, -1, 1, 0};
    public static boolean[][] visits;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visits = new boolean[N][N];
        ArrayList<Integer> nodeCountList = new ArrayList<>();

        //map 초기화
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++) {
                if(!visits[i][j] && map[i][j] != 0) {
                    int sum = 1;
                    sum += dfs(i,j);
                    nodeCountList.add(sum);
                    answer++;
                }
            }
        }


        Collections.sort(nodeCountList);

        System.out.println(answer);
        for (Integer count : nodeCountList) {
            System.out.println(count);
        }

    }

    public static int dfs(int row, int column) {

        visits[row][column] = true;
        int sum = 0;

        for(int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = column + dy[i];

            if(nx >= 0 && ny >= 0 && nx < map.length && ny < map.length){
                if(map[nx][ny] != 0 && visits[nx][ny] == false) {
                    sum++;
                    sum += dfs(nx, ny);
                }
            }
        }

        return sum;
    }


}
