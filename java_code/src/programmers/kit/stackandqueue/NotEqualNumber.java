package programmers.kit.stackandqueue;

import java.util.Stack;

/**
 * level 1
 * 같은 숫자는 싫어
 * stack 활용
 */
public class NotEqualNumber {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = {};

        int[] arr = {1,1,3,3,0,1,1};

        for (int i : arr) {
            if(stack.isEmpty()) {
                stack.push(i);
            }else if(stack.peek() != i) {
                stack.push(i);
            }
        }

        answer = new int[stack.size()];

        for(int i = stack.size() -1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        for (int i : answer) {
            System.out.print(i + " ");
        }

    }

}
