package baekjoon.dfs.silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 실버 2
 * 연결 요소의 개수
 *
 * 연결 요소란?
 * 정점간에 연결 했을 떄, 만들어지는 그래프의 수를 의미
 * ex) 1-2  와 3-4가 있다면
 * 1과 2 하나의 그래프
 * 3과 4 하나의 그래프
 * 즉, 연결 요소의 수는 2개가 된다.
 */
public class Problem11724 {

    public static LinkedList<Integer>[] graph;
    public static boolean[] visits;

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v_count = Integer.parseInt(st.nextToken());
        int edge_count = Integer.parseInt(st.nextToken());
        int answer = 0;

        graph = new LinkedList[v_count + 1];
        visits = new boolean[v_count + 1];

        for(int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }

        for(int i  = 0; i < edge_count; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1].add(v2);
            graph[v2].add(v1);

        }


        for(int i  = 1; i < visits.length; i++) {
            if(visits[i]) continue;

            dfs(i);
            answer++;
        }

        System.out.println(answer);

    }

    public static void dfs(int startNode) {

        visits[startNode] = true;

        for(int v : graph[startNode]) {
            if(!visits[v]) {
                visits[v] = true;
                dfs(v);
            }
        }

    }

}
