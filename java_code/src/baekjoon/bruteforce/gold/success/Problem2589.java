package baekjoon.bruteforce.gold.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 골드 5
 * 보물섬
 */
public class Problem2589 {

    public static int N,M,answer = Integer.MIN_VALUE;
    public static char[][] map;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for(int i = 0 ; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 'L') {
                    bfs(new Node(i, j, 0));
                }
            }
        }

        System.out.println(answer);

        br.close();
    }

    public static void bfs(Node startNode) {
        boolean[][] visits = new boolean[N][M];
        Queue<Node> q = new LinkedList<>();

        visits[startNode.getRow()][startNode.getColumn()] = true;
        q.add(startNode);

        while(!q.isEmpty()) {
            Node currentNode = q.poll();

            answer = Math.max(answer, currentNode.getTime());

            for(int i = 0; i < 4; i++) {
                int nx = currentNode.getRow() + dx[i];
                int ny = currentNode.getColumn() + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if(map[nx][ny] == 'L' && !visits[nx][ny]) {
                        q.add(new Node(nx, ny, currentNode.getTime() + 1));
                        visits[nx][ny] = true;
                    }
                }
            }
        }

    }

    static class Node {
        private int row;
        private int column;
        private int time;

        public Node(int row, int column, int time) {
            this.row = row;
            this.column = column;
            this.time = time;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }

        public int getTime() {
            return time;
        }
    }


}
