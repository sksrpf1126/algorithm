package baekjoon.dfs.silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 실버 2
 * 섬의 개수
 */
public class Problem4963 {

    public static int[][] map;
    public static boolean[][] visits;
    public static int w;
    public static int h;

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) {
                break;
            }

            map = new int[h][w];
            visits = new boolean[h][w];
            int answer = 0;

            //맵 초기화
            for(int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < map.length; i++) {
                for(int j = 0; j < map[i].length; j++) {
                    if(!visits[i][j] && map[i][j] != 0){
                        answer++;
                        dfs(i,j);
                    }
                }
            }

            System.out.println(answer);

        }

    }

    /**
     * map의 해당 값이 1인 경우에만 dfs 탐색
     * 값이 0이거나 방문을 이미 했더라면 return
     * 또한 탐색하고자 하는 행 인덱스나 열 인덱스가 배열의 범위를 벗어나도 종료
     * 
     * @param row 행 인덱스
     * @param column 열 인덱스
     */
    public static void dfs(int row, int column) {

        //배열의 범위를 벗어나면 종료
        if(row >= h || column >= w) {
            return;
        }

        if(row < 0 || column < 0){
            return;
        }
        //값이 0이거나 이미 방문을 했다면 종료
        if(map[row][column] == 0 || visits[row][column]) {
            return;
        }

        //방문처리
        visits[row][column] = true;

        for(int i = row - 1; i <= row + 1; i++) {
            for(int j = column -1; j <= column + 1; j++){
                dfs(i,j);
            }
        }

    }



}
