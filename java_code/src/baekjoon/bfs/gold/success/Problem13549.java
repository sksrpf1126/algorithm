package baekjoon.bfs.gold.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 골드 5
 * 숨바꼭질 3
 */
public class Problem13549 {

    public static int[] map = new int[100001];
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

        if(N < K){
            bfs(N, K);
        }else{
            map[K] = N - K;
        }

        System.out.println(map[K]);
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

            for(int i = 2; i >= 0; i--) {
                int nx;
                if(i == 2){
                    nx = currentPos * 2;
                }else{
                    nx = currentPos + dx[i];
                }

                if(nx >= 0 && nx < map.length) {
                    if(!visits[nx]){
                        visits[nx] = true;
                        if(i != 2) map[nx] = map[currentPos] + 1;
                        else map[nx] = map[currentPos];
                        q.offer(nx);
                    }
                }
            }
        }
    }


}
