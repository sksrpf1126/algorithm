package lecture.inflearn.kimtaewon.section_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 3. 최대 매출
 */
public class Problem03_03 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for(int i = 0; i < K; i++) answer += arr[i];

        int slide = answer;

        for(int i = K; i < N; i++) {
            slide = slide + arr[i] - arr[i-K];
            answer = Math.max(answer, slide);
        }

        System.out.println(answer);

    }


}
