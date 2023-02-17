package algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS(너비 우선 탐색)
 * 큐 자료구조를 활용
 */
public class BFS_Queue {
    public static boolean[] visits = new boolean[9];
    public static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
    public static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
//        BFS(1);
        BFSV2(1);
    }

    public static void BFSV2(int startNode) {
        q.offer(startNode);

        visits[startNode] = true;

        while (!q.isEmpty()) {
            int v = q.poll();

            System.out.print(v + " ");

            for(int node : graph[v]) {
                if(!visits[node]) {
                    q.offer(node);
                    visits[node] = true;
                }
            }
        }
    }









    public static void BFS(int startNode) {
        q.offer(startNode);

        visits[startNode] = true;

        while (!q.isEmpty()) {
            int v = q.poll();

            System.out.print(v + " ");

            for(int i = 0; i  < graph[v].length; i++) {
                if(!visits[graph[v][i]]) {
                    q.offer(graph[v][i]);
                    visits[graph[v][i]] = true;
                }
            }
        }
    }
}
