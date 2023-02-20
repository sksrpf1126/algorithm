package baekjoon.dfs.silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 실버 2
 * 유기농 배추
 */
public class Problem1012 {

    public static int[][] map;
    public static boolean[][] visits;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int columnCount;
    public static int rowCount;

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            columnCount = Integer.parseInt(st.nextToken());
            rowCount = Integer.parseInt(st.nextToken());
            map = new int[rowCount][columnCount];
            visits = new boolean[rowCount][columnCount];
            int cabbagePosCount = Integer.parseInt(st.nextToken());
            int answer = 0;

            for(int j = 0; j < cabbagePosCount; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[y][x] = 1;
            }

            //dfs 탐색 시작
            for(int row = 0; row < rowCount; row++) {
                for(int column = 0; column < columnCount; column++) {
                    if(map[row][column] != 0 && visits[row][column] == false) {
                        visits[row][column] = true;
                        dfs(row,column);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }

        br.close();
    }

    public static void dfs(int row, int column) {

        //상, 하, 좌, 우 총 4번 반복
        for(int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = column + dy[i];

            if(nx >= 0 && nx < rowCount && ny >= 0 && ny < columnCount) {
                if(map[nx][ny] != 0 && visits[nx][ny] == false) {
                    visits[nx][ny] = true;
                    dfs(nx, ny);
                }
            }
        }
    }

}
