package baekjoon.greedy.bronze.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 브론즈 3
 * 캥거루 세마리2
 */
public class Problem11034 {
    public static void main(String[] args) throws IOException {
        solution();

    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stoken;
        StringBuilder sb = new StringBuilder();
        String eof = "";


        int answer = 0;

        //eof 처리
        while ((eof = br.readLine()) != null) {
        stoken = new StringTokenizer(eof);
        int left = Integer.parseInt(stoken.nextToken());
        int mid = Integer.parseInt(stoken.nextToken());
        int right = Integer.parseInt(stoken.nextToken());

        //Math.max로 if else 대체 가능
        if(mid - left > right - mid) {
            answer = mid - left - 1;
        }else {
            answer = right - mid - 1;
        }

        sb.append(answer);

        System.out.println(sb);
        sb.setLength(0);
        }
        br.close();
    }
}
