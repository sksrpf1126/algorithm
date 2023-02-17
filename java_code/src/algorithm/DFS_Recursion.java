package algorithm;

/**
 * DFS(너비 우선 탐색)을 재귀함수로 구현함
 * https://codingnojam.tistory.com/44 참고
 *
 */
public class DFS_Recursion {

    public static boolean[] visits = new boolean[9];
    // 1부터 시작하기 위해서 0번째는 비워둠
    public static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
    
    public static void main(String[] args) {
        dfsv2(1);
    }

    public static void dfsv2(int startNode) {

        visits[startNode] = true;

        System.out.print(startNode + " > ");

        for(int i = 0; i < graph[startNode].length; i++) {

            if(!visits[graph[startNode][i]]) {
                dfsv2(graph[startNode][i]);
            }
        }
    }


    public static void dfs(int startIdx) {

        visits[startIdx] = true;

        System.out.print(startIdx + " > ");

        for (int node : graph[startIdx]) {

            if(!visits[node]) dfs(node);
        }

    }
}
