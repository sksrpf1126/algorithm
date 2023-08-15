package lecture.inflearn.kimtaewon.section_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 5. 최대 길이 연속부분수열
 */
public class Problem03_06 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0, cnt = 0, answer = Integer.MIN_VALUE;

        for(int rt = 0; rt < N; rt++) {
            if(arr[rt] == 0) cnt++;

            while(cnt > K) {
                if(arr[lt] == 0) cnt--;
                lt++;
            }

            answer = Math.max(answer, rt - lt + 1);
        }

        System.out.println(answer);



    }


}
