package lecture.inflearn.kimtaewon.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


/**
 * 11. 임시반장 정하기
 */
public class Problem02_11 {
    public static void main(String[] args) throws IOException {
        solution();
    }
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] array = new int[N][5];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 5; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int totalCount = 0, group, compareGroup;
        int answer = 0, maxGroup = Integer.MIN_VALUE;

        Set<Integer> friend = new HashSet<>();

        for(int i = 0; i < N; i++) {
            totalCount = 0;
            for(int j = 0; j < 5; j++) {
                group = array[i][j];

                for(int k = 0; k < N; k++) {
                    compareGroup = array[k][j];

                    if(group == compareGroup && !friend.contains(k)) {
                        friend.add(k);
                    }
                }

                totalCount += friend.size() - 1; //본인과 비교한 경우는 제외(현재 문제에서는 없어도 크게 상관 X)
            }

            if(totalCount > maxGroup) {
                answer = i + 1;
                maxGroup = totalCount;
            }

            friend.clear();
        }

        System.out.println(answer);

        br.close();
    }


}
