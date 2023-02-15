package baekjoon.bruteforce.silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 실버 3
 * 사탕 게임
 */
public class Problem3085 {

    public static char[][] candyArray;
    public static int N;
    public static int max = 0;

    public static void main(String[] args) throws IOException {
        solution();

    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        candyArray = new char[N][N];

        for(int i = 0; i < N; i++){
            String row = br.readLine();
            char[] chars = row.toCharArray();
            for(int j = 0; j < chars.length; j++) {
                candyArray[i][j] = chars[j];
            }
        }

        for(int i =0; i < N; i++){
            for(int j = 0; j < N; j++) {
                rowSwap(i,j);
                columnSwap(i,j);
            }
        }

        System.out.println(max);
    }

    public static void rowSwap(int rowIdx, int columnIdx) {
        //변경 불가능
        if(rowIdx >= N || columnIdx >= N - 1) {
            return;
        }

        //두 위치 변환
        swap(rowIdx, columnIdx, rowIdx, columnIdx + 1);
        rowCount(rowIdx);
        columnCount(columnIdx);
        columnCount(columnIdx + 1);
        
        //원래대로 되돌리기
        swap(rowIdx, columnIdx, rowIdx, columnIdx + 1);

    }

    public static void columnSwap(int rowIdx, int columnIdx) {
        //변경 불가능
        if(columnIdx >= N || rowIdx >= N - 1) {
            return;
        }

        //두 위치 변환
        swap(rowIdx, columnIdx, rowIdx + 1, columnIdx);
        rowCount(rowIdx);
        rowCount(rowIdx + 1);
        columnCount(columnIdx);

        //원래대로 되돌리기
        swap(rowIdx, columnIdx, rowIdx + 1, columnIdx);

    }

    public static void rowCount(int rowIdx) {
        int count = 1;

        for(int i = 0; i < N - 1; i++){
            if(candyArray[rowIdx][i] == candyArray[rowIdx][i+1]){
                count++;
            }else{
                if(count > max) {
                    max = count;
                }
                count = 1;
            }
        }

        if(count > max) {
            max = count;
        }
    }

    public static void columnCount(int columnIdx) {
        int count = 1;

        for(int i = 0; i < N - 1; i++){
            if(candyArray[i][columnIdx] == candyArray[i+1][columnIdx]){
                count++;
            }else{
                if(count > max) {
                    max = count;
                }
                count = 1;
            }
        }

        if(count > max) {
            max = count;
        }
    }

    public static void swap(int rowIdx, int columnIdx, int targetRowIdx, int targetColumnIdx) {
        char temp = candyArray[rowIdx][columnIdx];
        candyArray[rowIdx][columnIdx] = candyArray[targetRowIdx][targetColumnIdx];
        candyArray[targetRowIdx][targetColumnIdx] = temp;
    }
}
