package lecture.inflearn.kimtaewon.section_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 5. 소수
 */
public class Problem02_05 {

    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        solution();
    }
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numberArr = new int[N+1];

        for(int i = 2; i <= N; i++) {
            if(numberArr[i] == 0) answer++;

            for(int j = i * 2; j <= N; j += i) {
                numberArr[j] = 1;
            }
        }

        System.out.println(answer);

        br.close();
    }



}
