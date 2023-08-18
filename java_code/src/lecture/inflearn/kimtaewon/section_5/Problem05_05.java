package lecture.inflearn.kimtaewon.section_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


/**
 * 5. 쇠막대기
 */
public class Problem05_05 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int answer = 0;

        char[] charArray = str.toCharArray();

        for(int i = 0; i < charArray.length; i++) {
            if(charArray[i] == ')' && charArray[i - 1] == ')') {
                answer += 1;
                stack.pop();
            }else if(charArray[i] == ')') {
                stack.pop();
                answer += stack.size();
            }else {
                stack.push(charArray[i]);
            }
        }

        System.out.println(answer);

    }

}
