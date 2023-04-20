package programmers.level2.bruteforce.success;

import java.util.ArrayList;

/**
 * level 2
 * 전력망을 둘로 나누기
 */
public class ElectricGrid {

    public static ArrayList<Integer>[] tree;
    public static boolean[] visits;
    public static int checkNode;

    public static void main(String[] args) {
        int n = 4;
//        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        int[][] wires = {{1,2},{2,3},{3,4}};
        int answer = Integer.MAX_VALUE;
        tree = new ArrayList[n + 1];

        for(int i = 0; i < wires.length; i++) {

            for(int j = 0; j < n + 1; j++) {
                tree[j] = new ArrayList<>();
            }

            for(int j = 0; j < wires.length; j++) {
                if(i == j) continue;

                int v1 = wires[j][0];
                int v2 = wires[j][1];

                tree[v1].add(v2);
                tree[v2].add(v1);
            }
            visits = new boolean[n+1];
            checkNode = 1;
            dfs(1);
            answer = Math.min(answer, Math.abs(checkNode - (n - checkNode)));
        }

        System.out.println(answer);
    }

    public static void dfs(int startIdx) {
        visits[startIdx] = true;

        for(int v : tree[startIdx]) {
            if(visits[v]) continue;
            dfs(v);
            checkNode++;
        }
    }
}
