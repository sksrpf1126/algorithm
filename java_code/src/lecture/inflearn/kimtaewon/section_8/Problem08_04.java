package lecture.inflearn.kimtaewon.section_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 4. 중복순열
 */
public class Problem08_04 {

    public static int N, M;
    public static int[] numbers;
    public static int[] permNumbers;

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        permNumbers = new int[M];

        for(int i = 1; i <= N; i++) {
            numbers[i - 1] = i;
        }

        dfs(0);
    }

    public static void dfs(int count) {
        if(count == M) {
            for(int i : permNumbers) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < numbers.length; i++) {
            permNumbers[count] = numbers[i];
            dfs(count + 1);
        }

    }


}


