package lecture.inflearn.kimtaewon.section_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


/**
 * 4. 모든 아나그램 찾기
 */
public class Problem04_04 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        HashMap<Character, Integer> hm = new HashMap<>();

        for(int i = 0; i < str2.length(); i++) {
            char c = str2.charAt(i);
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        int lt = 0, answer = 0;

        char[] charArray = str1.toCharArray();

        for(int i = 0; i < str2.length() - 1; i++) {
            hm.put(charArray[i], hm.getOrDefault(charArray[i], 0) - 1);
            if(hm.get(charArray[i]) == 0) hm.remove(charArray[i]);
        }

        for(int rt = str2.length() - 1; rt < charArray.length; rt++) {
            hm.put(charArray[rt], hm.getOrDefault(charArray[rt], 0) - 1);
            if(hm.get(charArray[rt]) == 0) hm.remove(charArray[rt]);

            if(hm.size() == 0) answer++;

            hm.put(charArray[lt], hm.getOrDefault(charArray[lt], 0) + 1);
            if(hm.get(charArray[lt]) == 0) hm.remove(charArray[lt]);
            lt++;
        }

        System.out.println(answer);

    }


}
