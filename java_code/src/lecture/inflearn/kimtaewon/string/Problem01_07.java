package lecture.inflearn.kimtaewon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 7. 회문 문자열
 * 
 * StringBuilder로 뒤집은 문자열을 저장하는 변수와 기존의 문자열 변수와 equals로 비교하면 더 쉬운 방법으로 해결 가능
 */
public class Problem01_07 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(solution(str));
        br.close();
    }

    public static String solution(String str) {
        String answer = "YES";
        str = str.toLowerCase();

        int lt = 0, rt = str.length() -1;

        while (lt < rt) {
            if(str.charAt(lt) != str.charAt(rt)) {
                answer = "NO";
                break;
            }
            lt++;
            rt--;
        }

        return answer;
    }

}
