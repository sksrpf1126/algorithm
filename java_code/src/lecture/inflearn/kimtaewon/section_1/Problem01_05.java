package lecture.inflearn.kimtaewon.section_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 5. 특정 문자 뒤집기
 *
 * 새롭게 배운 내용
 * 나의 경우 알파벳의 여부를 판단하는 메서드를 직접 만들었지만
 * Character.isAlphabetic(Char c) 메서드가 존재한다.
 *
 */
public class Problem01_05 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(solution(str));

        br.close();
    }

    /**
     * 내가 푼 방법
     */
    public static String solution(String str) {

        char[] charArray = str.toCharArray();
        int lt = 0, rt = charArray.length - 1;

        while (lt < rt) {
            if(isAlphabet(charArray[lt]) && isAlphabet(charArray[rt])) {
                char tmp = charArray[lt];
                charArray[lt] =charArray[rt];
                charArray[rt] = tmp;
                lt++;
                rt--;
            }else if(!isAlphabet(charArray[lt])) {
                lt++;
            }else if(!isAlphabet(charArray[rt])) {
                rt--;
            }
        }

        return String.valueOf(charArray);
    }

    public static boolean isAlphabet(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }
}
