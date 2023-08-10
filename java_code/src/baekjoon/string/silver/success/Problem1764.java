package baekjoon.string.silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 실버 4
 * 듣보잡
 */
public class Problem1764 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> NSet = new HashSet<>();
        List<String> answerList = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            NSet.add(br.readLine());
        }
        for(int i = 0; i < M; i++) {
            String s = br.readLine();
            if(NSet.contains(s)) {
                answerList.add(s);
            }
        }

        Collections.sort(answerList);

        System.out.println(answerList.size());
        for(String s : answerList) {
            System.out.println(s);
        }

        br.close();
    }

}

