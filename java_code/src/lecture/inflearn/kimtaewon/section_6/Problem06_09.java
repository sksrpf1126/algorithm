package lecture.inflearn.kimtaewon.section_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * 9. 뮤직비디오
 */
public class Problem06_09 {

    public static int N, M;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        int mid, answer = 0;

        while (lt <= rt) {
            mid = (lt + rt) / 2;

            if(counting(mid)) {
                rt = mid - 1;
                answer = mid;
            }else{
                lt = mid + 1;
            }
        }

        System.out.println(answer);

    }

    public static boolean counting(int mid) {
        int total = 0, count = 1;

        for (int i = 0; i < arr.length; i++) {
            if(total + arr[i] > mid) {
                count++;
                total = arr[i];
            }else {
                total += arr[i];
            }
        }

        return count <= M;
    }

}
