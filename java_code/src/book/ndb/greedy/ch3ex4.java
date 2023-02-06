package book.ndb.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1이 될 때까지
 * 자바 정답 : https://github.com/ndb796/python-for-coding-test/blob/master/3/6.java
 */
public class ch3ex4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sr = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(sr.nextToken());
        int k = Integer.parseInt(sr.nextToken());
        int answer = 0;

        System.out.println(n + " " + k);

        while(n > 1) {
//            if(n % k == 0) {
//                n = n / k;
//            }else {
//                n--;
//            }

            n= n % k == 0 ? (n / k) : n - 1;

            answer++;
        }

        System.out.println("answer = " + answer);

    }
}
