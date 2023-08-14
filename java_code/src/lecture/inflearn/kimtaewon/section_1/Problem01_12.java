package lecture.inflearn.kimtaewon.section_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 12. 암호
 *
 * replace를 통해 해결하는 방법이 더 간결하고 반복문을 한번만 사용하면 됨.
 */
public class Problem01_12 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int wordCount = Integer.parseInt(br.readLine());
        String str = br.readLine();

        solution_2(wordCount, str);

        br.close();
    }

    public static void solution(int wordCount, String str) {
        String answer = "";

        for(int i = 0; i < wordCount; i++) {
            String word = str.substring(7 * i, 7 * (i+1));
            String binaryString = "";

            for(char c : word.toCharArray()) {
                binaryString += (c == '#' ? "1" : "0");
            }

            int num = Integer.parseInt(binaryString, 2);
            char a = (char) num;
            answer += a;

        }

        System.out.println(answer);
    }

    /**
     * 강사님 풀이 (replace 활용)
     */
    public static void solution_2(int wordCount, String str) {
        String answer = "";

        for(int i = 0; i < wordCount; i++) {
            String word = str.substring(0, 7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(word, 2);
            answer += (char) num;
            str = str.substring(7);
        }

        System.out.println(answer);
    }

}
