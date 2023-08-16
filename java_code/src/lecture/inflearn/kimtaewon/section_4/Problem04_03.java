package lecture.inflearn.kimtaewon.section_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


/**
 * 3. 매출액의 종류
 */
public class Problem04_03 {
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

        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i = 0; i < K - 1; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }

        int lt = 0;

        for(int rt = K - 1; rt < N; rt++) {
            hm.put(arr[rt], hm.getOrDefault(arr[rt], 0) + 1);
            System.out.print(hm.size() + " ");
            hm.put(arr[lt], hm.get(arr[lt]) - 1);

            if(hm.get(arr[lt]) == 0) hm.remove(arr[lt]);
            lt++;
        }

    }


}
