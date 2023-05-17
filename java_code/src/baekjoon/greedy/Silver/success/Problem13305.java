package baekjoon.greedy.Silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 실버 3
 * 주유소
 */
public class Problem13305 {

    public static int N;

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] distance = new int[N - 1];
        int[] literPrice = new int[N];

        for (int i = 0; i < N - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            literPrice[i] = Integer.parseInt(st.nextToken());
        }

        long sum = (long)distance[0] * literPrice[0];
        long min = literPrice[0];

        for(int i = 1; i < distance.length; i++) {
            if(min <= literPrice[i]) {
                sum += min * distance[i];
            }else {
                min = literPrice[i];
                sum += min * distance[i];
            }
        }

        System.out.println(sum);

        br.close();
    }
}
