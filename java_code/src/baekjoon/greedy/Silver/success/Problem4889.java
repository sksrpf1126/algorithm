package baekjoon.greedy.Silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem4889 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 1;

        while(true) {
            String str = br.readLine();

            if(str.charAt(0) == '-') {
                break;
            }

            Stack<Character> st = new Stack<>();

            for(Character c : str.toCharArray()) {
                if(!st.isEmpty() && st.peek() == '{' && c == '}') {
                    st.pop();
                }else {
                    st.push(c);
                }
            }

            int answer = 0;

            //무조건 짝수개이므로 반복문 한번 돌면서 2번씩 뺄 수 있음
            while(!st.isEmpty()) {
                Character c = st.pop();

                if(c == st.pop()) {
                    answer++;
                }else {
                    answer += 2;
                }

            }

            System.out.println(count +". " + answer);

            count++;
        }

        br.close();
    }
}
