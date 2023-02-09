package baekjoon.greedy.Silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 실버 1
 * 행렬
 */
public class Problem1080 {
    public static void main(String[] args) throws IOException {
        solution();

    }


    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sToken = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(sToken.nextToken());
        int M = Integer.parseInt(sToken.nextToken());
        int[][] A = new int[N][M];
        int[][] B = new int[N][M];
        int answer = 0;

        //행렬 A 입력
        for(int i = 0; i < N; i++) {
            String row = br.readLine();
            for(int j = 0; j < row.length(); j++) {
                A[i][j] = row.charAt(j) - '0';
            }
        }

        //행렬 B 입력
        for(int i = 0; i < N; i++) {
            String row = br.readLine();
            for(int j = 0; j < row.length(); j++) {
                B[i][j] = row.charAt(j) - '0';
            }
        }

        outLoop :
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {

                if(A[i][j] != B[i][j]) {
                    if(i + 2 >= N || j + 2 >= M){
                        //3X3 연산이 배열의 길이를 넘어서면 변환불가
                        answer = -1;
                        break outLoop;
                    }else {
                        //3X3 연산 실행
                        swap(A,i,j);
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);



        br.close();
    }

    private static void swap(int[][] A, int currentRow, int currentColumn) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                A[currentRow + i][currentColumn + j] = A[currentRow + i][currentColumn + j] == 0 ? 1 : 0;
            }
        }
    }
}
