package baekjoon.dfs.gold.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 골드 4
 * 알파벳
 *
 * Problem1987에 있는 방법은 arrayList에서 해당 알파벳이 들어있는지 판별하는데, 이에 대해 많은 시간을 낭비한다
 * V2에서는 map을 char가 아닌 int형으로, 즉 알파벳을 숫자로 바꾸어 저장하고, visit을 알파벳의 수 26개로 할당하여, 해당 알파벳에 대한 숫자가 visit에 true라면 모든 알파벳에 대한
 * 방문처리가 완료되며, 엄청난 시간단축이 가능해진다.
 *
 * Problem1987 방법의 속도 : 3884ms 메모리 : 20940KB
 *
 * 해당 V2 방법의 속도 : 900ms 메모리 : 15808KB
 * 
 * 4배이상의 속도 차이가 존재
 *
 */
public class Problem1987V2 {

//    public static Character[][] map;
    public static int[][] map;
//    public static ArrayList<Character> visits = new ArrayList<>();
    public static boolean[] visits = new boolean[26];
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

        map = new int[R][C];

        for(int i = 0; i < R; i++) {
            String s = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j) - 'A';
            }
        }

        dfs(0,0,1);

        System.out.println(max);

        br.close();
    }

    public static void dfs(int row, int column, int depth) {

        visits[map[row][column]] = true;
        max = Math.max(max, depth);

        for(int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = column + dy[i];

            if(nx >= 0 && nx < R && ny >=0 && ny < C){
                if(!visits[map[nx][ny]]) {

                    dfs(nx, ny, depth + 1);
                    visits[map[nx][ny]] = false;
                }
            }
        }
    }

}
