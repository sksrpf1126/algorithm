package baekjoon.bfs.gold.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 골드 5
 * 적록색약
 */
public class Problem10026 {

    public static char[][] map;
    public static int N;
    public static boolean[][] visits;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int normal = 0, redGreen = 0;

        map = new char[N][N];
        visits = new boolean[N][N];

        StringTokenizer st;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }


        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visits[i][j]) {
                    dfs(i,j);
                    normal++;
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 'G') map[i][j] = 'R';
            }
        }

        visits = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visits[i][j]) {
                    dfs(i,j);
                    redGreen++;
                }
            }
        }

        System.out.println(normal + " " + redGreen);


    }

    public static void dfs(int row, int column) {
        if(visits[row][column]) return;

        visits[row][column] = true;

        char target = map[row][column];

        for(int i = 0; i < 4; i++){
            int nx = row + dx[i];
            int ny = column + dy[i];

            if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if(!visits[nx][ny] && map[nx][ny] == target) {
//                    visits[nx][ny] = true;
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void bfs(int row, int column) {
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(row, column));
        visits[row][column] = true;
        char target = map[row][column];

        while (!q.isEmpty()) {
            Node currentNode = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = currentNode.getxPos() + dx[i];
                int ny = currentNode.getyPos() + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if(!visits[nx][ny] && map[nx][ny] == target) {
                        visits[nx][ny] = true;
                        q.offer(new Node(nx, ny));
                    }
                }
            }
        }
    }


    static class Node {
        private int xPos;
        private int yPos;

        public int getxPos() {
            return xPos;
        }

        public void setxPos(int xPos) {
            this.xPos = xPos;
        }

        public int getyPos() {
            return yPos;
        }

        public void setyPos(int yPos) {
            this.yPos = yPos;
        }

        public Node(int xPos, int yPos) {
            this.xPos = xPos;
            this.yPos = yPos;
        }
    }


}
