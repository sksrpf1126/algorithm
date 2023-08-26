package lecture.inflearn.kimtaewon.section_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;


/**
 * 2. 바둑이 승차
 */
public class Problem08_02 {

    public static int C, N, answer = 0;
    public static int[] numbers;
    public static boolean[] visits;

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        visits = new boolean[N];

        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        dfs(0);

        System.out.println(answer);

        br.close();
    }

    public static void dfs(int count) {
        if(count == N) {
            int sum = 0;
            for(int i = 0; i < N; i++) {
                if(visits[i]) {
                    sum += numbers[i];
                }
            }

            if(sum <= C) answer = Math.max(answer, sum);

        }else {
            visits[count] = true;
            dfs(count + 1);

            visits[count] = false;
            dfs(count + 1);
        }
    }



}
