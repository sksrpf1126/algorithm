package lecture.inflearn.kimtaewon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 3. 문장 속 단어
 */
public class Problem01_03 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(solution(str));

        br.close();
    }

    public static String solution(String str) {
        String answer = "";

        for (String s : str.split(" ")) {
            if(answer.length() < s.length()) answer = s;
        }

        return answer;
    }

}
