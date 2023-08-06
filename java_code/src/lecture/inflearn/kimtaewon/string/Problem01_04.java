package lecture.inflearn.kimtaewon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 4. 단어 뒤집기
 *
 * 새롭게 배운 내용
 * StringBuilder에서 제공해주는 reverse 메서드로 간단히 문자열을 뒤집을 수 있다.
 * 투 포인터 방식으로 접근하면 효율성을 더 증가시킬 수 있다.(lt, rt)
 */
public class Problem01_04 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] strs = new String[N];

        for(int i = 0; i < strs.length; i++) {
            strs[i] = br.readLine();
        }

        solution_3(strs);

        br.close();
    }

    /**
     * 내가 푼 방법
     */
    public static void solution(String[] strs) {
        String answer;
        for(String s : strs) {
            answer = "";
            for(int i = s.length() - 1; i >= 0; i--) {
                answer += s.charAt(i);
            }
            System.out.println(answer);
        }
    }

    /**
     * 위 방법보다 효율이 좋은 방법
     * 가운데를 기준으로 왼쪽 끝과 오른쪽 끝부터 서로 교환하는 방식으로 뒤집는 방식
     */
    public static void solution_2(String[] strs) {
        for(String s : strs) {
            char[] charArray = s.toCharArray();
            for(int i = 0; i < charArray.length / 2; i++) {
                char tmp = charArray[i];
                charArray[i] = charArray[charArray.length - 1 - i];
                charArray[charArray.length -1 -i] = tmp;
            }
            System.out.println(String.valueOf(charArray));
        }
    }

    /**
     * 강사님의 방법으로
     * solution_2 방법을 투 포인터 방식으로 깔끔하게 변경한 방법
     */
    public static void solution_3(String[] strs) {
        for(String s : strs) {
            char[] charArray = s.toCharArray();
            int lt = 0, rt = charArray.length - 1;

            while (lt < rt) {
                char tmp = charArray[lt];
                charArray[lt] = charArray[rt];
                charArray[rt] = tmp;
                lt++;
                rt--;
            }

            System.out.println(String.valueOf(charArray));
        }
    }

    /**
     * StringBuilder를 이용한 방법
     */
    public static void solution_4(String[] strs) {
        for(String s : strs) {
            String answer = new StringBuilder(s).reverse().toString();
            System.out.println(answer);
        }
    }
}
