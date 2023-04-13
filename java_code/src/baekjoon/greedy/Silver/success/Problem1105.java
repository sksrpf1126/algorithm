package baekjoon.greedy.Silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 실버 1
 * 팔
 */
public class Problem1105 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String L = st.nextToken();
        String R = st.nextToken();

        int answer = 0;

        if(L.length() == R.length()) {
            for(int i = 0; i < L.length(); i++) {
                if(L.charAt(i) == R.charAt(i) && L.charAt(i) == '8') answer++;
                else if(L.charAt(i) != R.charAt(i)) break;
            }
        }

        System.out.println(answer);

        br.close();
    }
}
