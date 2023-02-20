package baekjoon.dfs.gold.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 골드 5
 * 트리
 */
public class Problem1068 {

    public static ArrayList<Integer>[] graph;
    public static boolean[] visits;
    public static int deleteIdx;
    public static int leafNodeCount = 0;


    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N];
        visits = new boolean[N];

        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int rootNodeIdx = 0;

        //단방향
        for(int i = 0; i < N; i++) {
            int parentNode = Integer.parseInt(st.nextToken());
            if(parentNode == -1) {
                rootNodeIdx = i;
                continue;
            }
            graph[parentNode].add(i);
        }

        deleteIdx = Integer.parseInt(br.readLine());

        dfs(rootNodeIdx);

        System.out.println(leafNodeCount);

        br.close();
    }

    public static void dfs(int startVertex) {
        if(visits[startVertex] || startVertex == deleteIdx) return;

        visits[startVertex] = true;

        int size = graph[startVertex].size();

        if(size == 0 || (size == 1 && graph[startVertex].get(0) == deleteIdx)) {
            leafNodeCount++;
            return;
        }

        for(int v : graph[startVertex]) {
            if(!visits[v] && v != deleteIdx) {
                dfs(v);
            }
        }

    }

}
