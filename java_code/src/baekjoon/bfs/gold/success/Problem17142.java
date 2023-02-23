package baekjoon.bfs.gold.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 골드 3
 * 연구소 3
 *
 *
 */
public class Problem17142 {

    public static int N, M, answer = Integer.MAX_VALUE;
    public static int[][] originalMap;
    public static boolean[][] visits;
    public static boolean[] visits_2;
    public static ArrayList<Node> virusList = new ArrayList<>();
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

        originalMap = new int[N][N];
        visits = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++) {
                int number = Integer.parseInt(st.nextToken());
                originalMap[i][j] = number;
                if(number == 2) virusList.add(new Node(i,j));
            }
        }

        visits_2 = new boolean[virusList.size()];

        dfs2(0, 0);

        if(answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        }else{
            System.out.println(answer - 2);
        }

    }

    public static void dfs2(int virusCount, int start) {

        if(virusCount == M) {
            bfs2();
            return;
        }

        for(int i = start; i < virusList.size(); i++) {
            if(!visits_2[i]) {
                visits_2[i] = true;
                dfs2(virusCount + 1, i + 1);
                visits_2[i] = false;
            }
        }
    }

    public static void bfs2() {
        Queue<Node> q = new LinkedList<>();

        int [][] copyMap = new int[N][N];
        int maxVirusTime = 0;

        for(int i = 0; i < N; i++) {
            copyMap[i] = originalMap[i].clone();
        }


        for(int i = 0; i < virusList.size(); i++) {
            Node node = virusList.get(i);
            if(visits_2[i]) {
                q.offer(node);
            }else {
                copyMap[node.getX()][node.getY()] = -1;
            }
        }

        while (!q.isEmpty()) {
            Node currentNode = q.poll();

            if(!currentNode.activeYn) maxVirusTime = Math.max(maxVirusTime, copyMap[currentNode.getX()][currentNode.getY()]);

            for(int i = 0; i < 4; i++) {
                int nx = currentNode.getX() + dx[i];
                int ny = currentNode.getY() + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if(copyMap[nx][ny] == 0) {
                        copyMap[nx][ny] = copyMap[currentNode.getX()][currentNode.getY()] + 1;
                        q.offer(new Node(nx, ny));
                    }

                    if(copyMap[nx][ny] == -1) {
                        copyMap[nx][ny] = copyMap[currentNode.getX()][currentNode.getY()] + 1;
                        q.offer(new Node(nx, ny, true));
                    }
                }
            }
        }

        check(copyMap, maxVirusTime);

    }

    public static void check(int[][] map,int maxVirusTime) {

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 0) {
                    return;
                }
            }
        }

        answer = Math.min(answer, maxVirusTime);
    }

    static class Node {
        private int x;
        private int y;
        private boolean activeYn = false;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public boolean isActiveYn() {
            return activeYn;
        }

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, boolean activeYn) {
            this.x = x;
            this.y = y;
            this.activeYn = activeYn;
        }
    }


}
