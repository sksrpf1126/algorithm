package baekjoon.bfs.silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 실버 1
 * 나이트의 이동
 */
public class Problem7562 {

    public static int[][] map;
    public static boolean[][] visits;
    public static Queue<Position> q;
    //dx, dy는 좌측 상단에서부터 반시계방향으로 나이트 이동좌표 계산
    public static int[] dx = {-2, -1,  1,  2, 2, 1, -1, -2};
    public static int[] dy = {-1, -2, -2, -1, 1, 2,  2,  1};
    public static Position startPos;
    public static Position endPos;

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int size = Integer.parseInt(br.readLine());
            map = new int[size][size];
            visits = new boolean[size][size];
            q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            startPos = new Position(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine());
            endPos = new Position(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

            bfs(startPos.getX(), startPos.getY());

            System.out.println(map[endPos.getX()][endPos.getY()]);
        }

    }

    public static void bfs(int xPos, int yPos) {
        q.offer(new Position(xPos, yPos));

        visits[xPos][yPos] = true;

        while (!q.isEmpty()){
            Position currentPos = q.poll();

            if(currentPos.getX() == endPos.getX() && currentPos.getY() == endPos.getY()) {
                return;
            }

            for(int i = 0; i < 8; i++) {
                int nx = currentPos.getX() + dx[i];
                int ny = currentPos.getY() + dy[i];

                if(nx >= 0 && nx < map.length && ny >=0 && ny < map.length) {
                    if(visits[nx][ny] == false) {
                        map[nx][ny] = map[currentPos.getX()][currentPos.getY()] + 1;
                        visits[nx][ny] = true;
                        q.offer(new Position(nx, ny));
                    }
                }
            }


        }
    }

}

class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

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
}
