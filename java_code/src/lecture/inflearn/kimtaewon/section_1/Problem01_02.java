package lecture.inflearn.kimtaewon.section_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 2. 대소문자 변환
 *
 * 새롭게 배운 내용
 * str.toCharArray() => 문자열읠 문자 배열로 변환할 수 있으며 반복문으로도 사용 가능
 * Character.isLowerCase() or Character.isUpperCase() 를 통해 문자가 소문자인지 대문자인지 판단하는 메서드가 존재함
 */
public class Problem01_02 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(solution_2(str));

        br.close();
    }

    /**
     * 내가 푼 방법
     */
    public static String solution(String str) {
        String answer = "";

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c >= 97) {
                answer += Character.toUpperCase(c);
            }else {
                answer += Character.toLowerCase(c);
            }
        }

        return answer;
    }

    /**
     * 강사님이 푼 방법으로 제공해주는 메서드를 적극 사용
     * str.toCharArray() => 문자열읠 문자 배열로 변환할 수 있으며 반복문으로도 사용 가능
     * Character.isLowerCase() or Character.isUpperCase() 를 통해 문자가 소문자인지 대문자인지 판단하는 메서드가 존재함
     */
    public static String solution_2(String str) {
        String answer = "";

        for(char c : str.toCharArray()) {
            if(Character.isLowerCase(c)) answer += Character.toUpperCase(c);
            else answer += Character.toLowerCase(c);
        }

        return answer;
    }

}
