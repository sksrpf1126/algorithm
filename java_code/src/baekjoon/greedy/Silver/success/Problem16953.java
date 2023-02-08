package baekjoon.greedy.Silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 실버 2
 * A -> B
 */
public class Problem16953 {
    public static void main(String[] args) throws IOException {
        solution();

    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sToken = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(sToken.nextToken());
        int B = Integer.parseInt(sToken.nextToken());
        int answer = 1;

        while (A != B && (B % 2 == 0 || B % 10 == 1)) {
            if(B <= 0) {
                answer = -1;
                break;
            }

            if(B % 2 == 0) {
                B = B / 2;
                answer++;
            }else if(B % 10 == 1) {
                B = B / 10;
                answer++;
            }else {
                answer = -1;
                break;
            }
        }

        if(A != B){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }

        br.close();
    }
}
