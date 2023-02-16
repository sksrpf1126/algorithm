package programmers.kit.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * level 2
 * 큰 수 만들기(첫번째 시도 : O => 풀이가 너무 더러워서 좋은 코드를 보고 다시 품)
 */
public class BigNumberMaking {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String number = st.nextToken();
        int k = Integer.parseInt(st.nextToken());
        String stringBuilderAnswer = "";
        String stackAnswer = "";

        stringBuilderAnswer = stringBuilderSolution(number, k);
        stackAnswer = stackSolution(number, k);

        System.out.println("stringBuilder  answer = " + stringBuilderAnswer);
        System.out.println("stack  answer = " + stackAnswer);

    }

    /**
     * 가장 추천을 많이 받은 풀이방법으로, stack을 활용함
     */
    public static String stackSolution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);

            while(!st.isEmpty() && st.peek() < c && k-- > 0) {
                st.pop();
            }
            st.push(c);
        }

        for(int i = 0; i < result.length; i++) {
            result[i] = st.get(i);
        }

        return new String(result);
    }

    /**
     * StringBuiller의 deleteCharAt(int index), delete(int start, int end) 메서드를 활용한 해결 방법
     * 10번 케이스 시간 초과발생하지만 보고 배우기 위해서
     */
    public static String stringBuilderSolution(String number, int k) {
        StringBuilder sbNumber = new StringBuilder(number);

        for(int i = 0; i + 1 < sbNumber.length() && k > 0; i++) {
            // 앞자리 수가 뒷자리 수보다 작다면 앞자리 수를 제거
            // 제거 한 후 다시 맨 앞에서부터 검증하기 위해 i 값을 -1로
            if(sbNumber.charAt(i) < sbNumber.charAt(i + 1)){
                sbNumber.deleteCharAt(i);
                i = -1;
                k--;
            }
        }

        // 위 반복문으로 비교한 이후에도 숫자를 제거해야 한다면
        // 뒤에서 제거
        if(k != 0) {
            sbNumber.delete(sbNumber.length() - k, sbNumber.length());
        }

        return sbNumber.toString();
    }
}
