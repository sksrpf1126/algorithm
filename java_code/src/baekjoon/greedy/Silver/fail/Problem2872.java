package baekjoon.greedy.Silver.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 실버 2
 * 우리집엔 도서관이 있어
 * 처음에 연결리스트로 구현했지만 메모리 초과
 */
public class Problem2872 {
    public static void main(String[] args) throws IOException {
        solution();

    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList();
        int answer = 0;

        for(int i = 0; i < input; i++) {
            list.add(Integer.valueOf(br.readLine()));
        }

        ArrayList<Integer> listSorted = new ArrayList<>(list);
        Collections.sort(listSorted);

        int max = listSorted.get(listSorted.size() - 1);
        int maxTarget = listSorted.size() - 1;

        for(int i = list.size() - 1; i >= 0; i--) {
            if(list.get(i) == max && maxTarget != 0) {
                max = listSorted.get(--maxTarget);
            }else {
                answer++;
            }
        }

        System.out.println(answer);

        br.close();
    }
}
