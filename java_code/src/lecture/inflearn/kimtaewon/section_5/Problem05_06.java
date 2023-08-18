package lecture.inflearn.kimtaewon.section_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * 6. 공주 구하기
 */
public class Problem05_06 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            q.offer(i);
        }

        int count = 0;

        while (q.size() > 1) {
            Integer target = q.poll();
            count++;

            if(count != K) {
                q.offer(target);
            }else {
                count = 0;
            }
        }

        System.out.println(q.peek());

    }

}
