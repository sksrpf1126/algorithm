package lecture.inflearn.kimtaewon.section_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * 5. K번째 큰 수
 */
public class Problem04_05 {

    public static int N, K;
    public static int[] arr;
    public static Set<Integer> set = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());


        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        combination(0,0, 0);

        ArrayList<Integer> list = new ArrayList<>(set);

        Collections.sort(list, Collections.reverseOrder()); //list로 변환안하고 TreeSet에 reverseOrder 로 객체 생성해도 됨 TreeSet이 SortedSet을 구현한 클래스이므로 가능

        int answer = list.size() < K - 1 ? -1 : list.get(K - 1);

        System.out.println(answer);

    }

    public static void combination(int cnt, int sum, int start) {
        if(cnt == 3) {
            set.add(sum);
            return;
        }

        for(int i = start; i < arr.length; i++) {
            sum += arr[i];
            combination(cnt + 1, sum, i + 1);
            sum -= arr[i];
        }
    }


}
