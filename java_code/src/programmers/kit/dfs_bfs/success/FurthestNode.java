package programmers.kit.dfs_bfs.success;

import java.util.*;

/**
 * level 3
 * 가장 먼 노드
 *
 * DFS, BFS가 아닌 그래프 카테고리에 있지만, BFS로 풀 수 있어 여기에 추가
 */
public class FurthestNode {

    public static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    public static boolean[] visits;
    public static ArrayList<Integer>[] graph;

    public static void main(String[] args) {
        solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
    }

    public static void solution(int n, int[][] edge) {
        int answer = 0;
        visits = new boolean[n + 1];

        graph = new ArrayList[n + 1];

        for(int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < edge.length; i++) {
            int v1 = edge[i][0];
            int v2 = edge[i][1];

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        bfs();

        int max = 0;

        if(pq.size() >= 1) {
            max = pq.poll();
            answer++;
        }

        while(!pq.isEmpty()) {
            int current = pq.poll();

            if(max > current) {
                break;
            }

            answer++;
        }

        System.out.println(answer);
    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();

        //1번 노드부터 시작이므로 바로 방문 처리
        visits[1] = true;

        for(int i = 0; i < graph[1].size(); i++) {
            int node = graph[1].get(i);
            visits[node] = true;
            q.offer(new Node(node, 1));
            pq.add(1);
        }

        while(!q.isEmpty()) {
            Node now = q.poll();

            for(int i = 0; i < graph[now.getNext()].size(); i++) {
                int node = graph[now.getNext()].get(i);

                if(visits[node]) continue;

                visits[node] = true;
                q.offer(new Node(node, now.getDepth() + 1));
                pq.add(now.getDepth() + 1);
            }
        }

    }

    static class Node {
        private int next;
        private int depth;

        public int getNext() {
            return next;
        }

        public int getDepth() {
            return depth;
        }

        public Node(int next, int depth) {
            this.next = next;
            this.depth = depth;
        }
    }

}
