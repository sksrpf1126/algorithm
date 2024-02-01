package baekjoon.greedy.gold.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Problem1715 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            pq.add(Integer.valueOf(br.readLine()));
        }

        Integer answer = 0;

        if(N == 1) {
            System.out.println(answer);
            return;
        }

        while(pq.size() > 1 ) {
            Integer i1 = pq.poll();
            Integer i2 = pq.poll();
            pq.add(i1 + i2);
            answer += (i1 + i2);
        }

        System.out.println(answer);

        br.close();
    }
}
