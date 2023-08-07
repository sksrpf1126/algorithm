package lecture.inflearn.kimtaewon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 11. 문자열 압축
 */
public class Problem01_11 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        solution(str);

        br.close();
    }

    public static void solution(String str) {
        str += " ";
        int cnt = 1;
        String answer = "";

        for(int i = 0; i < str.length() - 1; i++) {
            if(str.charAt(i) == str.charAt(i + 1)) {
                cnt++;
            }else {
                answer += str.charAt(i);
                if(cnt != 1) answer += cnt;
                cnt = 1;
            }
        }

        System.out.println(answer);
    }

}
