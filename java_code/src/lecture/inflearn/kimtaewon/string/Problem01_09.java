package lecture.inflearn.kimtaewon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 9. 숫자만 추출
 *
 * Character.isDigit(Char c) 와 같이 알파벳 뿐만 아니라 숫자인지 아닌지를 판별하는 메서드가 존재한다.
 */
public class Problem01_09 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(solution(str));
        br.close();
    }

    public static int solution(String str) {
        String answer = "";

        for(char c : str.toCharArray()) {
            if(c >= '0' && c <= '9') {
                answer += c;
            }
        }

        return Integer.parseInt(answer);
    }

}
