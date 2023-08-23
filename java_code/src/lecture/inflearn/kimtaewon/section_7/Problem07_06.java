package lecture.inflearn.kimtaewon.section_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 1. 부분집합 구하기
 */
public class Problem07_06 {

    public static boolean[] visits;
    public static int[] numbers;
    public static int N;

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        numbers = new int[N];
        visits = new boolean[N];

        for(int i = 0; i < N; i++) {
            numbers[i] = i + 1;
        }

        dfs(0);

    }

    public static void dfs(int count) {
        if(count == N) {
            for(int i = 0; i < N; i++) {
                if(visits[i]) System.out.print(numbers[i] + " ");
            }
            System.out.println();
            return;
        }

        visits[count] = true;
        dfs(count + 1);

        visits[count] = false;
        dfs(count + 1);

    }


}
