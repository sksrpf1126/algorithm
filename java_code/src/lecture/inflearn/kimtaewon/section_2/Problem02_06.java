package lecture.inflearn.kimtaewon.section_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 6. 뒤집은 소수
 */
public class Problem02_06 {

    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        solution();
    }
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] numberArr = new String[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            numberArr[i] = st.nextToken();
        }

        for(int i = 0; i < numberArr.length; i++) {
            StringBuilder sb = new StringBuilder(numberArr[i]);
            int reverseNumber = Integer.parseInt(sb.reverse().toString());

            if(reverseNumber > 1 && isPrime(reverseNumber) != 0) System.out.print(reverseNumber + " ");
        }

        br.close();
    }

    public static int isPrime(int number) {
        boolean flag = true;

        for(int i = 2; i < number; i++) {
            if(number % i == 0) {
                flag = false;
                break;
            }
        }

        if(flag) return number;
        else return 0;
    }

}
