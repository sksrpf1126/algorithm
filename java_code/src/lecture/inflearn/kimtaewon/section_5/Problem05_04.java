package lecture.inflearn.kimtaewon.section_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


/**
 * 4. 후위식 연산
 */
public class Problem05_04 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Integer> stack = new Stack<>();

        for(char c : str.toCharArray()) {
            if(!Character.isDigit(c)) {
                int temp = calculator(c, stack.pop(), stack.pop());
                stack.push(temp);
            }else {
                stack.push((int) c - 48);
            }
        }

        System.out.println(stack.pop());

    }

    public static int calculator(char c, int num2, int num1) {

        switch (c) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                return 0;
        }
    }

}
