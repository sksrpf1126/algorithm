package lecture.inflearn.kimtaewon.section_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


/**
 * 1. 올바른 괄호
 */
public class Problem05_01 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> st = new Stack<>();
        String answer = "YES";

        for(char c : str.toCharArray()) {

            if(st.empty()) st.push(c);
            else if(st.peek() == c) st.push(c);
            else if(st.peek() == '(' && st.peek() != c) st.pop();

        }

        if(!st.isEmpty()) answer = "NO";

        System.out.println(answer);

    }

}
