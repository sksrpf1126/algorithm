package baekjoon.greedy.Silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 실버 2
 * 잃어버린 괄호
 */
public class Problem1541 {
    public static void main(String[] args) throws IOException {
        solution();

    }

    /**
     * 나는 first 변수를 통해 처음값인지 아닌지를 판단했지만 다른 분은 answer에 처음부터 Integer.MAX_VALUE 값을 집어넣으시고
     * 해당 값과 일치하면 처음이라 판단하여 덧셈을 한다. (변수 하나 선언 안해도 됨)
     */
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] minusSplit = br.readLine().split("-");
        boolean first = true;
        int answer = 0;
        int plusResult = 0;

        for(int i = 0; i < minusSplit.length; i++) {
            String[] plusSplit = minusSplit[i].split("\\+");
            for(int j = 0; j < plusSplit.length; j++) {
                plusResult += Integer.parseInt(plusSplit[j]);
            }

            if(first) {
                answer += plusResult;
                first = false;
            }else {
                answer -= plusResult;
            }

            plusResult = 0;
        }

        System.out.println(answer);

        br.close();
    }
}
