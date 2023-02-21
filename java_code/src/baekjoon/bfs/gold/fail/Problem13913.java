package baekjoon.bfs.gold.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 골드 4
 * 숨바꼭질 4
 *
 * 참고 : https://bcp0109.tistory.com/156
 */
public class Problem13913 {

    public static int[] map = new int[100001];
    public static int[] parent = new int[100001];
    public static boolean[] visits = new boolean[100001];
    public static int[] dx = {-1, 1};

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bfs(N, K);

        Stack<Integer> s = new Stack<>();
        s.push(K);
        int index = K;

        while (index != N) {
            s.push(parent[index]);
            index = parent[index];
        }

        System.out.println(map[K]);

        while (!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }

    }


    public static void bfs(int startPos, int k) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(startPos);
        visits[startPos] = true;

        while (!q.isEmpty()) {
            int currentPos = q.poll();

            if(currentPos == k) {
                return;
            }

            for(int i = 0; i < 3; i++) {
                int nx = 0;
                if(i == 2){
                    nx = currentPos * 2;
                }else{
                    nx = currentPos + dx[i];
                }

                if(nx >= 0 && nx < map.length) {
                    if(!visits[nx]){
                        visits[nx] = true;
                        map[nx] = map[currentPos] + 1;
                        parent[nx] = currentPos;
                        q.offer(nx);
                    }
                }
            }
        }
    }


}
