package baekjoon.greedy.gold.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 골드 4
 * 수 묶기
 */
public class Problem1744 {

    public static int N;

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pqMinus = new PriorityQueue<>();
        PriorityQueue<Integer> pqPlus = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        int number = 0;

        for(int i = 0; i < N; i++) {
            number = Integer.parseInt(br.readLine());
            if(number <= 0) {
                pqMinus.add(number);
            }else {
                pqPlus.add(number);
            }
        }

        if(N == 1 && N == 0) {
            System.out.println(number);
            System.exit(0);
        }

        while(!pqMinus.isEmpty()) {
            int n1 = pqMinus.poll();

            if(pqMinus.size() == 0) {
                answer += n1;
                break;
            }

            int n2 = pqMinus.poll();
            answer += n1 * n2;
        }

        while(!pqPlus.isEmpty()) {
            int n1 = pqPlus.poll();

            if(pqPlus.size() == 0) {
                answer += n1;
                break;
            }else if(n1 == 1) {
                answer += n1;
                continue;
            }

            int n2 = pqPlus.poll();

            if(n2 == 1) {
                answer += n1 + n2;
            }else {
                answer += n1 * n2;
            }

        }


        System.out.println(answer);

        br.close();
    }

}
