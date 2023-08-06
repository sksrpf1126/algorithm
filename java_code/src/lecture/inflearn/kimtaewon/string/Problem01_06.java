package lecture.inflearn.kimtaewon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 6. 중복문자제거
 * 
 * 새롭게 배운 부분
 * LinkedHashSet을 이용하여 해결 가능
 *
 * System.out.println(str.charAt(i) + " " + i + " " + str.indexOf(str.charAt(i))) 부분을 보면
 * indexOf는 항상 맨 앞에서부터 해당 문자를 찾음
 * 그렇기에 중간에 중복되는 문자의 인덱스 위치와 indexOf로 부터 찾은 인덱스와 다르다면 이미 앞에 해당 문자가 존재한다는 의미
 */
public class Problem01_06 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        for(int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i) + " " + i + " " + str.indexOf('c'));
        }
        System.out.println(solution(str));
        br.close();
    }

    public static String solution(String str) {
        String answer = "";
        int pos = 0;
        StringBuilder sb = new StringBuilder(str);

        while(sb.length() > 0) {
            String c = String.valueOf(sb.charAt(0));
            answer += c;

            while((pos = sb.indexOf(c)) != -1) {
                sb.deleteCharAt(pos);
            }
        }

        return answer;
    }

}
