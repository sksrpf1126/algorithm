package baekjoon.dfs.silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 실버 3
 * 바이러스
 */
public class Problem2606 {

    public static LinkedList<Integer>[] graph;
    public static boolean[] visits;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v_count = Integer.parseInt(br.readLine());
        int edge_count = Integer.parseInt(br.readLine());
        StringTokenizer st;

        //1부터 ~ N까지 저장. 0은 X
        graph = new LinkedList[v_count + 1];
        visits = new boolean[v_count + 1];

        for(int i = 0; i <= v_count; i++) {
            graph[i] = new LinkedList<>();
        }

        for(int i = 0; i < edge_count; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            //양방향 이므로
            graph[v2].add(v1);
            graph[v1].add(v2);
        }

        dfs(1);
        System.out.println(answer);

    }

    public static void dfs(int startNode) {

        visits[startNode] = true;

        for(int v : graph[startNode]) {

            if(!visits[v]) {
                visits[v] = true;
                answer += 1;
                dfs(v);
            }
        }
    }

}
