package lecture.inflearn.kimtaewon.section_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 3. LRU
 */
public class Problem06_04 {

    public static int[] cache;

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        cache = new int[S];
        int[] works = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            works[i] = Integer.parseInt(st.nextToken());
        }

        int existIdx;

        for(int i = 0; i < works.length; i++) {
            existIdx = -1;
            for(int j = 0; j < cache.length; j++) {
                if(cache[j] == works[i]) {
                    existIdx = j;
                    break;
                }
            }
            
            if(existIdx != -1) {
                //동일한 작업이 캐시에 있는 경우
                push(existIdx);
            }else {
                //동일한 작업이 캐시에 없는 경우
                push(cache.length - 1);
            }

            cache[0] = works[i];
        }

        for(int i : cache) {
            System.out.print(i + " ");
        }

    }

    public static void push(int idx) {
        for(int i = idx; i  > 0; i--) {
            cache[i] = cache[i - 1];
        }
    }


}
