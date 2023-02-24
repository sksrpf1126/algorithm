package programmers.kit.dfs_bfs.success;

/**
 * level 3
 * 네트워크
 *
 * dfs로 풀이
 */
public class Network {

    public static boolean[] visits;

    public static void main(String[] args) {
        solution(3, new int[][]{{1,1,0},{1,1,0},{0,0,1}});
        solution(3, new int[][]{{1,1,0},{1,1,1},{0,1,1}});
    }

    public static void solution(int n, int[][] computers) {
        int answer = 0;

        visits = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(visits[i]) continue;

            dfs(computers, computers[i], i);
            answer++;
        }

        System.out.println(answer);
    }

    public static void dfs(int[][] computers, int[] graph, int idx) {
        if(visits[idx]) return;

        visits[idx] = true;

        for(int i = 0; i < graph.length; i++) {
            //자기 자신이거나 값이 0이거나 이미 방문이 된 정점이라면
            if(i == idx || graph[i] == 0 || visits[i]) continue;

            dfs(computers, computers[i], i);

        }
    }


}
