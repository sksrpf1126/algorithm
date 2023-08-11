package programmers.level1.all.success;

import java.util.Arrays;

/**
 * level 1
 * 가장 가까운 같은 글자
 */
public class CloseWord {

    public static void main(String[] args) {
        solution("banana");
        solution("foobar");
    }

    public static void solution(String s) {
        int[] answer = new int[s.length()];

        for(int i = s.length() - 1; i >= 0; i--) {
            int front = s.indexOf(s.charAt(i));
            if(front != i) {
                for(int j = i - 1; j >= front; j--) {
                    if(s.charAt(i) == s.charAt(j)) {
                        answer[i] = i - j;
                        break;
                    }
                }
            }else {
                answer[i] = -1;
            }
        }

        System.out.println(Arrays.toString(answer));
    }

}
