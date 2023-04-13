package baekjoon.greedy.Silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 실버 1
 * 물병
 */
public class Problem1052 {

    public static int N, K, answer = 0;

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(K == 0) {
            System.out.println(-1);
        }else if(N <= K) {
            System.out.println(0);
        }else {
            calculation(N, K);
            System.out.println(answer);
        }

        br.close();
    }

    public static void calculation(int remainN, int remainK) {

        while (true) {
            int count = 1;
            if(remainK != 1) {
                while (remainN > count) {
                    count *= 2;
                }
                remainN = remainN - (count / 2);
                remainK = remainK -1;
            }else {
                if(remainK >= remainN) {
                    answer = 0;
                    return;
                }else {
                    while(true) {
                        count *= 2;
                        if(remainN == count) {
                            answer = 0;
                            return;
                        }else if(remainN < count) {
                            answer = count - remainN;
                            return;
                        }
                    }
                }
            }
        }

    }
}



/**
 * 매우 간단한 방법...
 *
 *        if (n <= k) {
 *             System.out.println(0);
 *             return;
 *         }
 *
 *         for (int i = 0; i < k - 1; i++) {
 *             int temp = 1;
 *             while (temp <= n) {
 *                 temp = temp << 1;
 *             }
 *             n -= (temp >> 1);
 *         }
 *
 *         if (n == 0) {
 *             System.out.println(0);
 *             return;
 *         }
 *
 *         int temp = 1;
 *         while (temp < n) {
 *             temp = temp << 1;
 *         }
 *         System.out.println(temp - n);
 **/