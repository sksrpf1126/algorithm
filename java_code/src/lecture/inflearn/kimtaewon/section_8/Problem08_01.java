package lecture.inflearn.kimtaewon.section_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 1. 합이 같은 부분집합
 */
public class Problem08_01 {

    public static int N;
    public static int[] numbers;
    public static boolean[] visits;

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        numbers = new int[N];
        visits = new boolean[N];

        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println("NO");


        br.close();
    }

    public static void dfs(int count) {
        if(count == N) {
            int permA = 0, permB = 0;
            for(int i = 0; i < N; i++) {
                if(visits[i]) {
                    permA += numbers[i];
                }else {
                    permB += numbers[i];
                }
            }

            if(permA == permB) {
                System.out.println("YES");
                System.exit(0);
            }
        }else {
            visits[count] = true;
            dfs(count + 1);

            visits[count] = false;
            dfs(count + 1);
        }
    }



}
