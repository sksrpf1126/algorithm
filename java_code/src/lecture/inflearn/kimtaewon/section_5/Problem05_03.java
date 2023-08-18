package lecture.inflearn.kimtaewon.section_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


/**
 * 3. 크레인 인형뽑기(카카오)
 */
public class Problem05_03 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int M = Integer.parseInt(br.readLine());
        int[] moves = new int[M];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++) {
            moves[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for(int i = 0; i < moves.length; i++) {
            int pos = moves[i] - 1;

            for(int j = 0; j < N; j++) {
                if(board[j][pos] != 0) {
                    if(!stack.isEmpty() && stack.peek() == board[j][pos]) {
                        answer += 2;
                        stack.pop();
                    }else {
                        stack.push(board[j][pos]);
                    }
                    board[j][pos] = 0;
                    break;
                }
            }

        }

        System.out.println(answer);


    }

}
