package lecture.inflearn.kimtaewon.section_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 7. 교육과정 설계
 */
public class Problem05_07 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String require = br.readLine();
        String orderStudy = br.readLine();

        Queue<Character> q = new LinkedList<>();

        for(char c : orderStudy.toCharArray()) q.offer(c);

        char[] charArray = require.toCharArray();
        int idx = 0;
        String answer = "YES";

        while(!q.isEmpty() && idx < charArray.length) {

            if(charArray[idx] == q.poll()) idx++;
        }


        if(idx != charArray.length) answer = "NO";

        System.out.println(answer);

    }

}
