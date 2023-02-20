package baekjoon.bruteforce.gold.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 골드 4
 * N-Queen
 *
 * 참고 : https://st-lab.tistory.com/118
 *
 */
public class Problem9663 {

    public static int N;
    //배열의 인덱스는 열의 위치를 의미하고, 인덱스의 내부 값은 행의 위치를 의미함 즉, 2차원 배열을 사용하지 않아도 됨.
    public static int[] queenPosArr;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        queenPosArr = new int[N];

        recursiveQueenPosition(0);

        System.out.println(answer);

        br.close();
    }

    public static void recursiveQueenPosition(int depth) {

        if(depth == N) {
            answer++;
            return;
        }

        for(int i = 0; i < N; i++) {
            queenPosArr[depth] = i;

            if(check(depth)) {
                recursiveQueenPosition(depth + 1);
            }
        }

    }

    public static boolean check(int col) {

        for(int i = 0; i < col; i++) {
            //같은 행에 존재하면 false
            if(queenPosArr[i] == queenPosArr[col]) return false;

            /**
             * 해당 퀸(i번째)의 대각선 이동 방향에 현재 두고자하는 퀸(col 번째 == depth)의 위치와 겹치는지 판단
             * 판단하는 방법은 대각선은 해당 퀸의 위치와 두고자 하는 퀸의 위치에서 행의 차와 열의 차가 동일하면 대각선에 위치한다는 의미이다.
             * 이해가 안되면 그림으로 그려볼 것
             */
            else if(Math.abs(i - col) == Math.abs(queenPosArr[i] - queenPosArr[col])) return false;
        }

        return true;
    }


}
