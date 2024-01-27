package baekjoon.greedy.Silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 싷버 3
 * 햄버거 분배
 */
public class Problem19941 {

    public static int N,K;
    public static char[] table;
    public static boolean[] visits;

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        table = new char[N];
        visits = new boolean[N];

        String tableString = br.readLine();

        for(int i = 0; i < N; i++) {
            table[i] = tableString.charAt(i);
        }

        int answer = 0;

        for(int i = 0; i < N; i++) {
            if(table[i] == 'P') {
                for(int j = i - K; j <= i + K; j++) {
                    if(j >= 0 && j < N && table[j] == 'H' && !visits[j]) {
                        answer++;
                        visits[j] = true;
                        break;
                    }
                }
            }
        }

        System.out.println(answer);

        br.close();
    }
}
