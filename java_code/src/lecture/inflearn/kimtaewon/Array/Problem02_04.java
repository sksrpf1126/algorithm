package lecture.inflearn.kimtaewon.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 4. 피보나치 수열
 */
public class Problem02_04 {
    public static void main(String[] args) throws IOException {
        solution();
    }
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] answer = new int[N];

        answer[0] = 1;
        answer[1] = 1;

        for(int i = 2; i < N; i++) {
            answer[i] = answer[i - 2] + answer[i - 1];
        }

        for(int i : answer) {
            System.out.print(i + " ");
        }

        br.close();
    }


}
