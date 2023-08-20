package lecture.inflearn.kimtaewon.section_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


/**
 * 5. 중복 확인
 */
public class Problem06_05 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        String answer =  "U";

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            Integer value = Integer.valueOf(st.nextToken());

            if(list.contains(value)) {
                answer = "D";
                break;
            }

            list.add(value);
        }

        System.out.println(answer);

    }


}
