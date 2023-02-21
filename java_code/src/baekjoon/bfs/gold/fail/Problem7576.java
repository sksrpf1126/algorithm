package baekjoon.bfs.gold.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 골드 5
 * 토마토
 *
 * 93%에서 시간초과가 발생 -> 0의 주위에 전부 -1이거나 막혀있다면 -1을 반환하도록 하는데, 이러면 1000 * 1000 (배열 크기)에 추가로 4번의 연산이 된다.
 * 즉 1000 * 1000 * 4의 최악의 시간복잡도가 발생하며, 이후에 토마토에 대한 연산이 이루어져야 하기 때문에 시간초과가 발생
 *
 * 또한 만약에 1이 여러개가 있는데 전부 -1로 둘러쌓여있다면? 위 방식은 0만을 기준으로 판별한다. 즉 위 방식은 접근자체가 틀렸으며, 너무 어렵게 생각했던 것이다.
 *
 * 참고 : https://zoonvivor.tistory.com/131
 *
 * 그냥 큐가 빌 때까지 +1씩 해나가면서 연산을 한 뒤에 0이 하나라도 남아 있다면 -1을 출력하면 되고, 아니라면 최댓값을 출력하면 정답이다..
*/
public class Problem7576 {

    static class Position{
        private int x;
        private int y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int N, M, answer = 0;
    public static int[][] map;
    public static boolean[][] visits;
    public static Queue<Position> q = new LinkedList<>();
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int number = Integer.parseInt(st.nextToken());
                map[i][j] = number;
                if(number == 1) q.offer(new Position(i,j));
            }
        }

        bfs();

        System.out.println(answer);

    }

    public static void bfs() {

        while (!q.isEmpty()){
            Position currentPos = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = currentPos.getX() + dx[i];
                int ny = currentPos.getY() + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if(map[nx][ny] == 0) {
                        map[nx][ny] = map[currentPos.getX()][currentPos.getY()] + 1;
                        q.offer(new Position(nx,ny));
                    }
                }
            }
        }

        int max = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    answer = -1;
                    return;
                }

                max = Math.max(max, map[i][j]);
            }
        }

        answer = max - 1;
    }

}
