package lecture.inflearn.kimtaewon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 10. 가장 짧은 문자거리
 */
public class Problem01_10 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        char t = st.nextToken().charAt(0);

        solution(str, t);

        br.close();
    }

    public static void solution(String str, char t) {
        int p = 1000;
        int[] answer = new int[str.length()];

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == t) {
                p = 0;
            }else {
                p++;
            }
            answer[i] = p;
        }

        p = 1000;

        for(int i = str.length() - 1; i >= 0; i--) {
            if(str.charAt(i) == t) {
                p = 0;
            }else {
                p++;
                answer[i] = Math.min(answer[i], p);
            }
        }

        for(int i : answer) {
            System.out.print(i + " ");
        }

    }

}
