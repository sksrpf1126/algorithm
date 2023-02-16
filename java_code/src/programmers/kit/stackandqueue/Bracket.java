package programmers.kit.stackandqueue;

import java.util.Stack;

/**
 * level 2
 * 올바른 괄호
 */
public class Bracket {
    public static void main(String[] args) {
        String str = ")()(";
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        char[] charArr = str.toCharArray(); //효율성 문제됨


        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(!stack.empty() && stack.peek() == ')') {
                answer = false;
                break;
            }

            if(!stack.isEmpty() && stack.peek() != charArr[i]) {
                stack.pop();
            }else{
                stack.push(charArr[i]);
            }
        }

        if(!stack.isEmpty()) {
            answer = false;
        }

        System.out.println(answer);

    }
}
