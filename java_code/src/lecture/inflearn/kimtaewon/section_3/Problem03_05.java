package lecture.inflearn.kimtaewon.section_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 5. 연속된 자연수의 합
 */
public class Problem03_05 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int lt = 1, sum = lt, answer = 0;

        for(int rt = 2; rt < N; rt++) {
            sum += rt;

            while (sum > N) {
                sum -= lt;
                lt++;
            }

            if(sum == N) answer++;
        }

        System.out.println(answer);

    }


}
