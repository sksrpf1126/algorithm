package lecture.inflearn.kimtaewon.section_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 3. 삽입 정렬
 */
public class Problem06_03 {
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

        int temp, j;

        for(int i = 1; i < N; i++) {
            temp = arr[i];
            j = i - 1;

            while (j >= 0 && temp < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }

            arr[j + 1] = temp;
        }

        for(int i : arr) {
            System.out.print(i + " ");
        }

    }


}
