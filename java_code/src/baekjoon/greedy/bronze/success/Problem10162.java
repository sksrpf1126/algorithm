package baekjoon.greedy.bronze.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 브론즈 4
 * 전자레인지
 */
public class Problem10162 {
    public static void main(String[] args) throws IOException {
        solution();

    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        int aCount = 0;
        int bCount = 0;
        int cCount = 0;

        if(t % 10 != 0) {
            sb.append(-1);
            System.out.println(sb);
            return;
        }

        if(t >= 300) {
            aCount = t / 300;
            t = t - (300 * aCount);
        }
        if(t >= 60) {
            bCount = t / 60;
            t = t -  (60 * bCount);
        }
        if(t >= 10){
            cCount = t / 10;
            t = t -  (10 * cCount);
        }

        sb.append(aCount + " ").append(bCount + " ").append(cCount + " ");

        System.out.println(sb);

        br.close();
    }
}
