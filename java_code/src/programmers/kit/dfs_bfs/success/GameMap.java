package programmers.kit.dfs_bfs.success;

import java.util.LinkedList;
import java.util.Queue;

/**
 * level 2
 * 게임 맵 최단거리
 * dfs는 N,M까지 도달한 경로가 최단거리가 아닐 가능성이 존재함
 * 최단거리는 bfs로 접근
 *
 */
public class GameMap {

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

    public static boolean[][] visits;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}});
        solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}});
    }

    public static void solution(int[][] maps) {
        //행 길이
        int N = maps.length;
        //열 길이
        int M = maps[0].length;

        visits = new boolean[N][M];

        bfs(maps, 0, 0);

        if(!visits[N-1][M-1]) {
            System.out.println(-1);
        }else {
            System.out.println(maps[N - 1][M - 1]);
        }
    }


    public static void bfs(int[][] maps, int row, int column) {
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(row,column));
        visits[row][column] = true;

        while(!q.isEmpty()) {
            Node now = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = now.getX() + dx[i];
                int ny = now.getY() + dy[i];

                if(nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length) {
                    if(!visits[nx][ny] && maps[nx][ny] != 0) {
                        visits[nx][ny] = true;
                        maps[nx][ny] = maps[now.getX()][now.getY()] + 1;
                        q.offer(new Node(nx, ny));
                    }
                }
            }
        }

    }




}
