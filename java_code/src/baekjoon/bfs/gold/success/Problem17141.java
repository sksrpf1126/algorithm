package baekjoon.bfs.gold.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 골드 4
 * 연구소 2
 *
 * dfs, bfs와 dfs2 bfs2 조합이 있다.
 * dfs는 2차원 배열 전체에서 2라는 값을 가진 애를 탐색하는데, 이러면 배열 전체에서 찾을 수 밖에 없게 된다.
 * 배열의 크기가 NXN이라면 한번 탐색시에 최악의 경우 O(N^2)의 시간복잡도가 소요된다.
 * 그리고 이를 재귀함수로 계속호출하다보니 시간초과가 발생하였다.
 *
 * 이를 해결하기 위해서 처음에 입력받을 때부터 값이 2라면 ArrayList(virusList)에 담아놓고서
 * dfs2에서는 해당 arrayList를 대상으로만 반복을 돌린다.
 * 즉, 처음부터 바이러스를 둘 수 있는 좌표들만을 가지고 있기 때문에, 최대 O(M)의 탐색시간이 소요된다.
 *
 * 그리고, 방문 처리를 해당 arrayList에 맞게끔 하고, 여기서 바이러으싀 둘 자리의 경우는 "조합"이므로, start 파라미터를 통해서 현재i번재의 뒤에서부터만 반복문이 실행되게 하였다.
 *
 *
 */
public class Problem17141 {

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
                copyMap[node.getX()][node.getY()] = 0;
            }
        }

        while (!q.isEmpty()) {
            Node currentNode = q.poll();

            maxVirusTime = Math.max(maxVirusTime, copyMap[currentNode.getX()][currentNode.getY()]);

            for(int i = 0; i < 4; i++) {
                int nx = currentNode.getX() + dx[i];
                int ny = currentNode.getY() + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if(copyMap[nx][ny] == 0) {
                        copyMap[nx][ny] = copyMap[currentNode.getX()][currentNode.getY()] + 1;
                        q.offer(new Node(nx, ny));
                    }
                }
            }
        }

        check(copyMap, maxVirusTime);

    }

    public static void dfs(int virusCount) {

        if(virusCount == M) {
            bfs();
            return;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(originalMap[i][j] == 2 && !visits[i][j]) {
                    visits[i][j] = true;
                    dfs(virusCount + 1);
                    visits[i][j] = false;
                }
            }
        }
    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();

        int [][] copyMap = new int[N][N];
        int maxVirusTime = 0;

        for(int i = 0; i < N; i++) {
            copyMap[i] = originalMap[i].clone();
        }

        for(int i = 0 ; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(copyMap[i][j] == 2) {
                    if(visits[i][j]) {
                        q.offer(new Node(i,j));
                    }else{
                        copyMap[i][j] = 0;
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            Node currentNode = q.poll();

            maxVirusTime = Math.max(maxVirusTime, copyMap[currentNode.getX()][currentNode.getY()]);

            for(int i = 0; i < 4; i++) {
                int nx = currentNode.getX() + dx[i];
                int ny = currentNode.getY() + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if(copyMap[nx][ny] == 0) {
                        copyMap[nx][ny] = copyMap[currentNode.getX()][currentNode.getY()] + 1;
                        q.offer(new Node(nx, ny));
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
