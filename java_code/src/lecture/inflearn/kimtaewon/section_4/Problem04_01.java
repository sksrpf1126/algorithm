package lecture.inflearn.kimtaewon.section_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


/**
 * 1. 학급 회장
 */
public class Problem04_01 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        Map<Character, Integer> result = new HashMap<>();
        int max = Integer.MIN_VALUE, cnt;
        char answer = ' ';

        for(char c : str.toCharArray()) {
            cnt = 1;
            if(result.containsKey(c)) {
                cnt = result.get(c) + 1;
                result.replace(c, cnt);
            }
            else result.put(c, cnt);

            if(max < cnt) {
                max = cnt;
                answer = c;
            }

        }

        System.out.println(answer);



    }


}
