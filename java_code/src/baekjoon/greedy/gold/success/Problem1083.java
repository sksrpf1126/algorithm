package baekjoon.greedy.gold.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 골드 5
 * 정렬
 */
public class Problem1083 {

    public static int N, S;

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        S = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            if(S <= 0) break;

            int maxIdx = findMax(arr, i, i + S + 1);

            for(int j = maxIdx; j > i; j--) {
                swap(arr, j - 1, j);
                S--;
                if(S <= 0) break;
            }

        }

        for (int i : arr) {
            System.out.print(i + " ");
        }

        br.close();
    }

    public static int findMax(int[] array, int startIdx, int endIdx) {
        if(endIdx > N) endIdx = N;
        int maxIdx = startIdx;

        for(int i = startIdx + 1; i < endIdx; i++) {
            if(array[maxIdx] < array[i]) maxIdx = i;
        }

        return maxIdx;
    }

    public static void swap(int[] array, int idx1, int idx2) {
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }


}
