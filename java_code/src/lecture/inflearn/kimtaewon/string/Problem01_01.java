package lecture.inflearn.kimtaewon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 1. 문자 찾기
 */
public class Problem01_01 {

    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = br.readLine();
        char target = br.readLine().charAt(0);

        for(int i = 0; i < words.length(); i++) {
            if(Character.toLowerCase(words.charAt(i)) == Character.toLowerCase(target)) {
                answer++;
            }
        }

        System.out.println(answer);

        br.close();
    }

}
