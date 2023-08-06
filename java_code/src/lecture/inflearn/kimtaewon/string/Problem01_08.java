package lecture.inflearn.kimtaewon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 8. 유효한 팰린드롬
 */
public class Problem01_08 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(solution(str));
        br.close();
    }

    public static String solution(String str) {
        String answer = "YES";
        str = str.toLowerCase();

        int lt = 0, rt = str.length() -1;

        while (lt < rt) {
            if(!Character.isAlphabetic(str.charAt(lt))) {
                lt++;
            }else if(!Character.isAlphabetic(str.charAt(rt))) {
                rt--;
            }else if(str.charAt(lt) != str.charAt(rt)){
                answer = "NO";
                break;
            }else {
                lt++;
                rt--;
            }
        }

        return answer;
    }

}
