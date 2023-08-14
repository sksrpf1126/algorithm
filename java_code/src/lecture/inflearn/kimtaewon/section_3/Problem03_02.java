package lecture.inflearn.kimtaewon.section_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * 2. 공통원소 구하기
 */
public class Problem03_02 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] NArr = new int[N];
        List<Integer> answer = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            NArr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] MArr = new int[M];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++) {
            MArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(NArr);
        Arrays.sort(MArr);

        int p1 = 0, p2 = 0;

        while(p1 < N && p2 < M) {
            if(NArr[p1] == MArr[p2]) {
                answer.add(NArr[p1]);
                p1++;
                p2++;
            }else if(NArr[p1] > MArr[p2]) {
                p2++;
            }else {
                p1++;
            }
        }

        for(int i : answer) {
            System.out.print(i + " ");
        }

    }


}
