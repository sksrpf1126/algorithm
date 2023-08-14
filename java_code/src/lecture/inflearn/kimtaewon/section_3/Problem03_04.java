package lecture.inflearn.kimtaewon.section_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 4. 연속부분수열
 */
public class Problem03_04 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0, sum = 0, answer = 0;

        for(int rt = 0; rt < N; rt++) {
            sum += arr[rt];

            while(sum > M) {
                sum -= arr[lt++];
            }

            if(sum == M) answer++;
        }

        System.out.println(answer);

    }


}
