package lecture.inflearn.kimtaewon.section_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


/**
 * 1. 큰 수 출력하기
 */
public class Problem02_01 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        answer.add(arr[0]);

        for(int i = 1; i < arr.length; i++) {
            if(arr[i - 1] < arr[i]) answer.add(arr[i]);
        }

        for(Integer i : answer) {
            System.out.print(i + " ");
        }

        br.close();
    }

}
