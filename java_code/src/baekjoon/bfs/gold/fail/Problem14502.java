package baekjoon.bfs.gold.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 골드 4
 * 연구소 1
 *
 * 벽 3개를 어떻게 반복문을 돌리면서 세울것인가 고민을 하다가 깔끔한 방법이 떠오르지 않아서 참고하였음
 * dfs를 통해서 순열과 같은 개념으로 벽을 세울 수 있다는 것을 알 수 있었음.
 *
 * 이를 동일한 방식으로 연구소 2(17141번) 문제를 풀어보자.
 */
public class Problem14502 {

    public static int N, M, answer = 0;
    public static int[][] originalMap;
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

        originalMap = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++) {
                originalMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(answer);

    }

    public static void dfs(int wallCount) {

        if(wallCount == 3) {
            bfs();
            return;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(originalMap[i][j] == 0) {
                    originalMap[i][j] = 1;
                    dfs(wallCount + 1);
                    originalMap[i][j] = 0;
                }
            }
        }
    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();

        for(int i = 0 ; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(originalMap[i][j] == 2) q.offer(new Node(i,j));
            }
        }

        int [][] copyMap = new int[N][M];

        for(int i = 0; i < N; i++) {
            copyMap[i] = originalMap[i].clone();
        }

        while (!q.isEmpty()) {
            Node currentNode = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = currentNode.getX() + dx[i];
                int ny = currentNode.getY() + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if(copyMap[nx][ny] == 0) {
                        copyMap[nx][ny] = 2;
                        q.offer(new Node(nx, ny));
                    }
                }
            }
        }

        check(copyMap);

    }

    public static void check(int[][] map) {
        int cnt = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) cnt++;
            }
        }

        answer = Math.max(answer, cnt);
    }

    static class Node {
        private int x;
        private int y;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
