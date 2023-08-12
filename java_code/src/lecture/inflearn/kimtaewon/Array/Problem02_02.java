package lecture.inflearn.kimtaewon.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 2. 보이는 학생
 */
public class Problem02_02 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int front = arr[0];
        int answer = 1;

        for(int i = 0; i < arr.length; i++) {
            if(front < arr[i]) {
                front = arr[i];
                answer++;
            }
        }

        System.out.println(answer);

        br.close();
    }

}
