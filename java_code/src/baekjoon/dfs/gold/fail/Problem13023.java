package baekjoon.dfs.gold.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 골드 5 (반례 참고하여 재풀이)
 * ABCDE
 *
 * 처음 답안을 제출했을 때 44%에서 실패하였다. 문제의 접근 방향은 맞았다는 것인데, 어디선가 반례가 존재하는 것 같아서 고민하고 찾던 도중 아래의 반례 하나를 발견하였다.
 *
 * 5 5
 * 0 1
 * 1 3
 * 1 4
 * 4 3
 * 3 2
 *
 * 정답 : 1
 *
 * 0에서 dfs 호출 시 1에서 두가지 방향을 선택할 수 있다.
 * 첫번째 0 -> 1 -> 3 -> 2  depth 3 이므로 조건에 맞지 않는다.
 * 두번째 0 -> 1 -> 4 -> 3 -> 2 depth 4 이므로 조건에 맞는다.
 *
 * 하지만 dfs 탐색에서 여러 방향으로 퍼지는 경우 먼저 탐색이 이루어지는 방향으로 탐색이 된다.
 * 즉, 위에서 첫번째로 탐색이 이루어진다면 0 -> 1 -> 3 -> 2  여기서 2까지 탐색 후 3으로 되돌아간 뒤 4와 3은 연결이 되어 있으므로 3 -> 4로 간다.
 * 즉, 0 -> 1 -> 3 -> 2 -> (3으로 되돌아간 뒤) 4 가 되며 3으로 되돌아 간뒤(depth - 1) 4로 탐색이 이루어져서 depth가 3이 되어버려서 0을 반환하게 되고
 * 이는 정답과는 다른 결과가 나온다.
 *
 * 이를 해결하기 위해서는 해가되는 경로(depth가 4 이상)가 아니게 된 경우에는 해당 경로의 방문을 초기화를 해준다.
 * 그럼 0 -> 1 -> 3 -> 2 는 해가 아니므로 되돌아가면서 방문을 초기화하게 되고 0 -> 1 -> 3 -> 4 이 또한 depth가 3이 되면서 해가 아니므로 되돌아가면서 방문을 초기화 해준다.
 * 이제 0 -> 1에서 재탐색이 이루어지고, 0 -> 1 -> 3으로 가는 탐색방향은 전부 해가 아니므로
 * 0 -> 1 -> 4 로 탐색이 이루어진다.
 * 그러면  0 -> 1 -> 4 -> 3 -> 2 즉, depth가 4가 되어서 해답이 된다.
 *
 * 순열의 개념과 비슷하다고 보면 더 쉽게 이해가 된다.
 *
 * 정리하면, 해답이 모든 탐색의 경우를 고려해야 한다면, 또 다른 말로는 A -> B로 가는 길을 찾고자 할 때 가는 길의 수가 여러개가 존재한다면
 * dfs로 한번의 탐색만 한다면 단 하나의 길만을 알려준다는 것이다.
 * 모든 길로 탐색을 하고 싶다면 위와 같이 하나의 길을 간 후에 초기화를 해주자.
 * bfs 또한 동일하지만  dfs와 차이점으로는 최소의 거리를 찾을 때 효과적이다.
 * *
 */
public class Problem13023 {

    public static LinkedList<Integer>[] graph;
    public static boolean[] visits;

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int vCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());

        graph = new LinkedList[vCount];
        visits = new boolean[vCount];

        for(int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }

        //인접 리스트 양방향으로 세팅
        for(int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

//        for (LinkedList<Integer> i : graph) {
//            for (Integer integer : i) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }

        for(int i = 0; i < graph.length; i++) {
            dfs(i, 0);
            visits = new boolean[vCount];
        }

        System.out.println(0);


    }

    public static void dfs(int startNode, int depth) {

        if(depth >= 4) {
            System.out.println(1);
            System.exit(0);
        }

        visits[startNode] = true;

        for(int v : graph[startNode]) {
            if(!visits[v]) {
                dfs(v, depth + 1);
                visits[v] = false;
            }
        }
    }

}
