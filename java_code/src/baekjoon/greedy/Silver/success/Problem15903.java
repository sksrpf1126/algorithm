package baekjoon.greedy.Silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 실버 1
 * 카드 합체 놀이
 */
public class Problem15903 {
    public static void main(String[] args) throws IOException {
        solution();

    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sToken = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(sToken.nextToken());
        int M = Integer.parseInt(sToken.nextToken());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long answer = 0;
        long sum = 0;

        sToken = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            pq.add(Long.valueOf(sToken.nextToken()));
        }

        for(int i = 0; i < M; i++) {
            sum = pq.poll() + pq.poll();
            pq.add(sum);
            pq.add(sum);
        }

        int count = pq.size();

        for(int i = 0; i < count; i++) {
            answer += pq.poll();
        }

        System.out.println(answer);

        br.close();
    }
}
