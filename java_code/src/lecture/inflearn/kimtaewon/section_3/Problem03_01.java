package lecture.inflearn.kimtaewon.section_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


/**
 * 1. 두 배열 합치기
 */
public class Problem03_01 {
    public static void main(String[] args) throws IOException {
        solution_2();
    }

    /**
     * ArrayList로 쉽게 하는 방법
     */
    public static void solution_2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> answer = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            answer.add(Integer.valueOf(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++) {
            answer.add(Integer.valueOf(st.nextToken()));
        }

        Collections.sort(answer);

        for(int i : answer) {
            System.out.print(i + " ");
        }

    }
    
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] NArr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            NArr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] MArr =  new int[M];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++) {
            MArr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0, rt = 0, idx = 0;
        int[] answer = new int[N + M];

        while (lt < N || rt < M) {
            if(lt == N) answer[idx++] = MArr[rt++];
            else if(rt == M) answer[idx++] = NArr[lt++];
            else if(NArr[lt] >= MArr[rt]) answer[idx++] = MArr[rt++];
            else answer[idx++] = NArr[lt++];
        }

        for(int i : answer) {
            System.out.print(i+ " ");
        }

        br.close();
    }


}
