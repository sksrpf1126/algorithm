package baekjoon.greedy.Silver.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 실버 1
 * 회의실 배정(해결하지 못한 문제)
 * 시간표를 최대한 많이 배정하거나 선택하는 문제를 "활동 선택 문제(Activity Selection problem)" 라고 한다.
 * 한 사람이 하나의 활동에 대해서만 작업할 수 있을 때 최대한 많은 활동을 할 수 있는 수를 구하는 문제
 * 참고 : https://st-lab.tistory.com/145
 * 인터벌 스케쥴링을 알아야 문제를 풀 수 있다.
 */
public class Problem1931 {
    public static void main(String[] args) throws IOException {
        solution();

    }

    /**
     * 끝나는 시간이 가장 빠른 회의를 선택하면 되며, 같은 시간에 끝나는 경우 시작 시간을 오름차순으로 정렬해야 한다.
     */
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sToken;
        int N = Integer.parseInt(br.readLine());
        Integer[][] time = new Integer[N][2];

        for(int i = 0; i < N; i++) {
            sToken = new StringTokenizer(br.readLine());
            time[i][0] = Integer.valueOf(sToken.nextToken());
            time[i][1] = Integer.valueOf(sToken.nextToken());
        }

        Arrays.sort(time, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {

                //0번째 인덱스는 startTime, 1번째 인덱스는 endTime이다.
                //종료시간이 같다면 시작시간을 오름차순으로 정렬
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }

                //종료시간이 같지 않다면 종료시간을 오름차순으로 정렬
                return o1[1] - o2[1];
            }
        });

        int answer = 0;
        int preEndTime = 0;

        for(int i = 0; i < N; i++) {
            if(time[i][0] >= preEndTime) {
                answer++;
                preEndTime = time[i][1];
            }
        }

        System.out.println(answer);

        br.close();
    }
}
