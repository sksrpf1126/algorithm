package lecture.inflearn.kimtaewon.section_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 1. 재귀함수
 */
public class Problem07_01 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        printNumber(N);
    }

    public static void printNumber(int number) {
        if(number == 0) return;
        else {
            printNumber(number - 1);
            System.out.print(number + " ");
        }
    }


}
