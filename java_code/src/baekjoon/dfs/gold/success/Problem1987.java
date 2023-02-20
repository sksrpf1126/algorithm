package baekjoon.dfs.gold.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 골드 4
 * 알파벳
 */
public class Problem1987 {

    public static Character[][] map;
    public static ArrayList<Character> visits = new ArrayList<>();
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int max = 0;
    public static int R = 0;
    public static int C = 0;

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new Character[R][C];

        for(int i = 0; i < R; i++) {
            String s = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        visits.add(map[0][0]);
        dfs(0,0,1);

        System.out.println(max);

        br.close();
    }

    public static void dfs(int row, int column, int depth) {
        if(max < depth) {
            max = depth;
        }

        for(int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = column + dy[i];

            if(nx >= 0 && nx < R && ny >=0 && ny < C){
                if(!visits.contains(map[nx][ny])) {
                    Character c = map[nx][ny];
                    visits.add(c);
                    dfs(nx, ny, depth + 1);
                    visits.remove(c);
                }
            }
        }
    }

}
