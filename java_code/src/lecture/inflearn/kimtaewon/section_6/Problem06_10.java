package lecture.inflearn.kimtaewon.section_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * 10. 마구간 정하기
 */
public class Problem06_10 {

    public static int N, C;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int lt = 1, rt = arr[N - 1];
        int mid, answer = 0;
        while(lt <= rt) {
            mid = (lt + rt) / 2;

            if(counting(mid)) {
                lt = mid + 1;
                answer = mid;
            }else {
                rt = mid - 1;
            }
        }

        System.out.println(answer);

    }

    public static boolean counting(int mid) {
        int count = 1;
        int endPoint = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] - endPoint >= mid) {
                count++;
                endPoint = arr[i];
            }
        }

        return count >= C;
    }

}
