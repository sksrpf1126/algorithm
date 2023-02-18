package baekjoon.dfs.silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 실버 2
 * DFS와 BFS
 */
public class Problem1260 {

    public static LinkedList<Integer>[] graph;
    public static Queue<Integer> bfsQueue = new LinkedList<>();
    public static boolean[] visits;

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v_count = Integer.parseInt(st.nextToken());
        int edge_count = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());

        graph = new LinkedList[v_count + 1];
        visits = new boolean[v_count + 1];

        //정점의 수는 4개 그러면 1~4를 채움
        //graph.length = 5 즉, 1을 빼줘야함
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }

        for(int i = 0; i < edge_count; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        for(int i = 0; i < graph.length; i++) {
            Collections.sort(graph[i]);
        }

        dfs(startNode);
        visits = new boolean[v_count + 1];
        System.out.println();
        bfs(startNode);

    }

    public static void dfs(int startNode) {

        visits[startNode] = true;

        System.out.print(startNode + " ");

        for(int i : graph[startNode]) {
            if(!visits[i]) {
                visits[i] = true;
                dfs(i);
            }
        }
    }

    public static void bfs(int startNode) {

        bfsQueue.offer(startNode);

        visits[startNode] = true;

        while (!bfsQueue.isEmpty()) {
            int v = bfsQueue.poll();
            System.out.print(v + " ");

            for(int node : graph[v]) {
                if(!visits[node]) {
                    visits[node] = true;
                    bfsQueue.offer(node);
                }
            }
        }
    }

}
