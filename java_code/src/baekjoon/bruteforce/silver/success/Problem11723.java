package baekjoon.bruteforce.silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 실버 5
 * 집합
 */
public class Problem11723 {

    public static void main(String[] args) throws IOException {
        solution();

    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int bit = 0;

        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String select = st.nextToken();
            int x;
            switch (select) {
                case "add" :
                    x = Integer.parseInt(st.nextToken());
                    bit = bit | (1<<(x-1));
                    break;
                case "remove" :
                    x = Integer.parseInt(st.nextToken());
                    bit = bit & ~(1<<(x-1));
                    break;
                case "check" :
                    x = Integer.parseInt(st.nextToken());
                    sb.append((bit & (1<<(x-1))) != 0 ? "1\n" : "0\n");
                    break;
                case "toggle" :
                    x = Integer.parseInt(st.nextToken());
                    bit = bit ^ (1<<(x-1));
                    break;
                case "all" :
                    bit = (1 << 20) -1;
                    break;
                case "empty" :
                    bit = 0;
                    break;
            }

        }

        System.out.println(sb);

    }

}
