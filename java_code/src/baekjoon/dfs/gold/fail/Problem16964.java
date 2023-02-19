package baekjoon.dfs.gold.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 골드 3
 * DFS 스폐셜 저지
 */
public class Problem16964 {

    public static ArrayList<Integer>[] graph;
    public static boolean[] visits;
    public static int idx = 1;
    public static boolean nextVertex = true;
    public static ArrayList<Integer> orderArr = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];

        for(int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        visits = new boolean[N + 1];

        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            orderArr.add(Integer.valueOf(st.nextToken()));
        }

        if(orderArr.get(0) == 1) {
            visits[1] = true;
            dfs2(1);
            if(nextVertex) {
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }else {
            System.out.println(0);
        }

        br.close();
    }

    public static void dfs(int startVertex) {
        if(!nextVertex) return;

//        HashSet<Integer> childVertex = new HashSet<>();
//        ArrayList<Integer> childVertexList = (ArrayList<Integer>) graph[startVertex].clone();
        ArrayList<Integer> childVertexList= new ArrayList<>();

        for (Integer vertex : graph[startVertex]) {
            if(!visits[vertex]) {
                visits[vertex] = true;
                childVertexList.add(vertex);
            }
        }

        int size = childVertexList.size();

        for(int i = 0; i < size; i++) {
            if(childVertexList.remove(orderArr.get(idx))){
                dfs(orderArr.get(idx++));
            }else{
                System.out.println("start : " + startVertex);
                nextVertex = false;
                return;
            }
        }

    }

    public static void dfs2(int startVertex) {
        if(!nextVertex) return;

        HashSet<Integer> set = new HashSet<>();
        for (Integer vertex : graph[startVertex]) {
            if(!visits[vertex]) {
                visits[vertex] = true;
                set.add(vertex);
            }
        }

        int size = set.size();

        for(int i = 0; i < size; i++) {
            if(set.remove(orderArr.get(idx))){
                dfs2(orderArr.get(idx++));
            }else{
                System.out.println("start : " + startVertex);
                nextVertex = false;
                return;
            }
        }

    }


}
