package baekjoon.dfs.silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 실버 4
 * 바닥 장식
 */
public class Problem1388 {

    public static int N;
    public static int M;
    public static char[][] map;
    public static boolean[][] visits;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sToken = new StringTokenizer(br.readLine());
        N = Integer.parseInt(sToken.nextToken());
        M = Integer.parseInt(sToken.nextToken());

        map = new char[N][M];
        visits = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            map[i] = str.toCharArray();
        }

        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                dfs(i,j);
            }
        }

        System.out.println(answer);

        br.close();
    }

    public static void dfs(int row, int column) {
        if(visits[row][column]) {
            return;
        }

        answer += 1;
        visits[row][column] = true;

        char c = map[row][column];

        if(c == '-') {
            for(int i = column + 1; i < map[row].length; i++) {
                if(c == map[row][i]){
                    visits[row][i] = true;
                }else{
                    break;
                }
            }
        }else if(c == '|') {
            for(int i = row + 1; i < map.length; i++) {
                if(c == map[i][column]){
                    visits[i][column] = true;
                }else {
                    break;
                }
            }
        }

    }

}
