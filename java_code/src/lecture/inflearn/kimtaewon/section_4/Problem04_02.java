package lecture.inflearn.kimtaewon.section_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


/**
 * 2. 아나그램
 */
public class Problem04_02 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        HashMap<Character, Integer> map = new HashMap<>();
        String answer = "YES";

        for(char c : str1.toCharArray()) {
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        for(char c : str2.toCharArray()) {
            if(!map.containsKey(c) || map.get(c) == 0) {
                answer = "NO";
                break;
            }
            map.put(c, map.get(c) - 1);
        }

        System.out.println(answer);

    }


}
