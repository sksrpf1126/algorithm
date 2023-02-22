package baekjoon.bfs.gold.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 골드 4
 * 알고스팟 (실패 => 답은 제출 안함)
 *
 * 너무 어렵게 생각하다가 못 풀었다.
 * 뿌순다는 의미에 너무 과하게 생각했지만, 결국 지나온 동선에 1이 있으면 카운트 0이라면 노카운트 하는 식으로 지나온 동선에 1의 수를 파악하면 되는 거였다.
 *
 * 참고 : https://velog.io/@jh5253/%EB%B0%B1%EC%A4%80-1261-%EC%95%8C%EA%B3%A0%EC%8A%A4%ED%8C%9F-Java%EC%9E%90%EB%B0%94
 * 큐로 풀 경우에는 경로에 우선순위가 없어 어떠한 것이 (N,M) 좌표에 먼저 올지 모른다. 그래서 해당 좌표에 도착한 모든 경우를 Math.min을 통해 최솟값을 찾아야 하는데
 * 이러면 경로가 무수히 많다면 시간에도 문제가 생기고, 위 글에서는 큐에서 메모리 초과가 발생하였다고 한다. (모든 경로를 우선순위 없이 탐색하기 때문)
 *
 * 하지만 이 문제를 큐가 아닌 우선순위 큐를 사용하여, 벽을 적게 부순 경로를 우선적으로 꺼내어서 재탐색함으로써, 시간과 자원을 아낄 수 있다.
 */
public class Problem1261 {

    static class Step implements Comparable<Step> {
        private int row;
        private int column;
        private int wallCount;

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getColumn() {
            return column;
        }

        public void setColumn(int column) {
            this.column = column;
        }

        public int getWallCount() {
            return wallCount;
        }

        public void setWallCount(int wallCount) {
            this.wallCount = wallCount;
        }

        public Step(int row, int column, int wallCount) {
            this.row = row;
            this.column = column;
            this.wallCount = wallCount;
        }

        @Override
        public int compareTo(Step other) {
            return this.wallCount - other.wallCount;
        }
    }

    public static int[][] map;
    public static boolean[][] visits;
    public static int N,M, answer = 0;
    public static PriorityQueue<Step> pq = new PriorityQueue<>();
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
        visits = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        bfs();

        System.out.println(answer);

    }

    public static void bfs() {

        pq.offer(new Step(0,0,0));
        visits[0][0] = true;

        while (!pq.isEmpty()) {
            Step currentStep = pq.poll();

            if(currentStep.getRow() == N - 1 && currentStep.getColumn() == M - 1){
                answer = currentStep.getWallCount();
                return;
            }

            for(int i = 0; i < 4; i++) {
                int nx = currentStep.getRow() + dx[i];
                int ny = currentStep.getColumn() + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if(!visits[nx][ny] && map[nx][ny] == 1){
                        visits[nx][ny] = true;
                        pq.offer(new Step(nx, ny, currentStep.getWallCount() + 1));
                    }

                    if(!visits[nx][ny] && map[nx][ny] == 0){
                        visits[nx][ny] = true;
                        pq.offer(new Step(nx, ny, currentStep.getWallCount()));
                    }
                }
            }

        }

    }


}
