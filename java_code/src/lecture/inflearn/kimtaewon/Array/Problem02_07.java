package lecture.inflearn.kimtaewon.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 7. 점수계산
 */
public class Problem02_07 {
    public static void main(String[] args) throws IOException {
        solution();
    }
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] testResult = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            testResult[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int currentScore = 0;

        for(int i = 0; i < testResult.length; i++) {
            if(testResult[i] == 1) {
                currentScore++;
                answer += currentScore;
            }else {
                currentScore = 0;
            }
        }

        System.out.println(answer);

        br.close();
    }


}
