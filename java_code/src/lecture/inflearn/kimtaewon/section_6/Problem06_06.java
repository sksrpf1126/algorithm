package lecture.inflearn.kimtaewon.section_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * 6. 장난꾸러기
 */
public class Problem06_06 {

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

        int[] arrCopy = Arrays.copyOf(arr, arr.length); //arr.clone() 메서드와 동일
        Arrays.sort(arrCopy);

        for(int i = 0; i < N; i++) {
            if(arr[i] != arrCopy[i]) {
                System.out.print(i + 1 + " ");
            }
        }

    }


}
