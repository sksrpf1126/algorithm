package baekjoon.bruteforce.silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 실버 1
 * 회전초밥
 */
public class Problem2531 {

    public static int N, D, K, C, answer = 0;
    public static int[] sushiList;

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        sushiList = new int[N];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            sushiList[i] = Integer.parseInt(br.readLine());
        }


        for(int leftIdx = 0; leftIdx < N; leftIdx++) {
            int rightIdx = leftIdx;
            Set<Integer> eatLIst = new HashSet<>();
            eatLIst.add(sushiList[leftIdx]);
            int count = 1; //leftIdx에 해당하는 초밥 섭취

            for(int i = count; i < K; i++) {
                rightIdx++;

                if(rightIdx == N) {
                    rightIdx = 0;
                }

                eatLIst.add(sushiList[rightIdx]);

            }

            if(!eatLIst.contains(C)) {
                eatLIst.add(C);
            }

            answer = Math.max(answer, eatLIst.size());
        }

        System.out.println(answer);

        br.close();
    }


}
