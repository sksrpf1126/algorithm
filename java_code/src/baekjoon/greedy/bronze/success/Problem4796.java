package baekjoon.greedy.bronze.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 브론즈 1
 * 캠핑
 */
public class Problem4796 {
    public static void main(String[] args) throws IOException {
        solution();

    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stoken;
        StringBuilder sb = new StringBuilder();
        String eof = "";


        int count = 0;

        //eof 처리
        while ((eof = br.readLine()) != null) {
        int answer = 0;
        stoken = new StringTokenizer(eof);
        int L = Integer.parseInt(stoken.nextToken());
        int P = Integer.parseInt(stoken.nextToken());
        int V = Integer.parseInt(stoken.nextToken());

        if(L == 0 && L == P && P == V) {
            break;
        }

        answer = (V / P) * L;
        answer += Math.min(L, (V % P));

        sb.append("Case ").append(++count).append(": ").append(answer);
        System.out.println(sb);
        sb.setLength(0);
        }

        br.close();
    }
}
