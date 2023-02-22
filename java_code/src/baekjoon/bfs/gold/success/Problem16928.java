package baekjoon.bfs.gold.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 골드 5
 * 뱀과 사다리 게임
 */
public class Problem16928 {

    static class Step implements Comparable<Step> {

        private int pos;
        private int diceCount;

        public int getPos() {
            return pos;
        }

        public int getDiceCount() {
            return diceCount;
        }

        public Step(int pos, int diceCount) {
            this.pos = pos;
            this.diceCount = diceCount;
        }

        @Override
        public int compareTo(Step o) {
            return this.diceCount - o.diceCount;
        }
    }

    public static int[] map = new int[101];
    public static boolean[] visits = new boolean[101];
    public static PriorityQueue<Step> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start] = end;
        }

        bfs(1);


    }

    public static void bfs(int startPos) {
        pq.offer(new Step(startPos, 0));
        visits[startPos] = true;

        while (!pq.isEmpty()) {
            Step currentStep = pq.poll();

            if(currentStep.getPos() == 100) {
                System.out.println(currentStep.getDiceCount());
                return;
            }

            for(int i = 1; i <= 6; i++) {
                int nx = currentStep.getPos() + i;

                if(nx > 100) break;

                if(map[nx] != 0) {
                    int move = map[nx];
                    if(!visits[move]){
                        visits[move] = true;
                        pq.offer(new Step(move, currentStep.getDiceCount() + 1));
                    }
                }else{
                    if(!visits[nx]){
                        visits[nx] = true;
                        pq.offer(new Step(nx, currentStep.getDiceCount() + 1));
                    }
                }
            }
        }
    }


}
