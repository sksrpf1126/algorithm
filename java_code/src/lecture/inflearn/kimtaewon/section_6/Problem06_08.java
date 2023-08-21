package lecture.inflearn.kimtaewon.section_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * 8. 이분탐색
 */
public class Problem06_08 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int findNumber = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int low = 0, high = arr.length - 1;
        int mid;
        int answer = 0;

        while (low <= high) {
            mid = (high + low) / 2;

            if(findNumber == arr[mid]) {
                answer = mid;
                break;
            }else if(findNumber > arr[mid]) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        System.out.println(answer + 1);
    }

}
