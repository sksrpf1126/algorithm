package lecture.inflearn.kimtaewon.section_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


/**
 * 2. 괄호문자제거
 */
public class Problem05_02 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();

        for(char c : str.toCharArray()) {
            if(c != ')') stack.push(c);
            else {
                String temp = "";

                while (!stack.isEmpty()) {
                    Character pop = stack.pop();
                    if(pop == '(') {
                        temp = "";
                        break;
                    }
                    else temp += pop;
                }

                answer.append(temp);
            }
        }

        while(!stack.isEmpty()) {
            Character pop = stack.pop();
            if(pop != '(') answer.append(pop);
        }

        System.out.println(answer.reverse());

    }

}
