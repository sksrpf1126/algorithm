package baekjoon.greedy.gold.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 골드 5
 * 강의실 배정(실패)
 *
 * 틀린 이유
 * 실버1 1931문제와 비슷하기 때문에, 1931번 문제와 동일하게 하나의 강의실에 최대한 많은 수업을 할수 있도록 하면 최소의 강의실 수가 나올 줄 알았다.
 * 그래서, 끝나는 시간으로 정렬하고, 끝나는 시간이 같다면 시작 시간으로 다시 정렬을 하도록 구현했다.
 * 하지만, 위 방법은 말 그대로 그저 한 강의실에 최대한 많은 수업을 할 수 있도록 할 뿐 최소의 강의실을 사용하도록 하는 거와는 별개의 문제라는 것이다.
 *
 * 반례
 * 1 2                                   1 2
 * 1 4     이를 끝나는 시간으로 정렬하면 =>  1 4
 * 2 6                                   4 5
 * 4 5                                   2 6
 *
 * 정답 : 2
 * 끝나는 시간으로 정렬한 경우 : 3
 * 끝나는 시간으로 정렬해서 풀면, (1,2) 하나의 강의실 사용 (1,4) 하나의 강의실 사용  이후 4 5에서 (1,2)의 강의실을 그대로 사용
 * 마지막으로 (2,6)에는 새로운 강의실을 사용해아혀므로 3개의 강의실을 사용하게 된다.
 *
 * 최소의 강의실을 사용하기 위해서는 시작 시간으로 정렬을 해야 한다. 흔히 음식점의 회전율을 생각하면 된다.
 * 손님이 음식을 다먹고 일어나면 기다리는 손님들을 웨이팅 순서대로 바로바로 채워주는 것이다.
 *
 * 웨이팅 순서(먼저 온 순서)가 아닌 끝나는 시간으로 정렬한다는 것은 음식을 빨리 먹을 수 있는 순으로 손님들을 받는다는 것이다.
 * 위 (4,5)와 (2,6)에서 (2,6)이 먼저 왔지만 테이블을 차지하는 시간이 길다는 이유로 (4,5)를 먼저 받게되며, 이는 하나의 테이블에는 많은 손님을 받을지언정 (2,6)을 위한 새로운 테이블이
 * 추가가 된다는 것은 피할수가 없다.
 *
 */
public class Problem11000 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    /**
     * 다른 분들이 우선순위 큐를 활용하는 것을 보고, 우선순위 큐를 활용하는 방법으로 다시 생각해서 푼 방법
     * 내 방법(아래에 mySolution)은 메모리 : 65044 KB, 시간 : 2988 ms로 이중 for문에 의해 시간복잡도가 최악의 경우에는 o(n^2)로 시간초과가 발생할 가능성이 존재한다.
     * 하지만 아래 방법은 메모리 : 69604 KB, 시간 : 660 ms 로 메모리는 조금 더 사용하지만, 한번의 반복문에는 O(n)이며 우선순위 큐의 삭제 또는 삽입 과정에서는
     * 이진 트리의 정렬과정에 의한 시간복잡도인 O(log n)의 시간이 걸린다.
     * 즉, 시간복잡도는 O(nlogn)이 된다.
     * 
     * 맨 위 주석내용인 반례와 반례에 따른 정렬을 이해했다면 쉽게 이해가 가능할 것이다.
     * 우선순위 큐의 첫번째 값은 제일 작은 값 즉, 현재 강의실에서 가장 수업이 빨리 끝나는 시간이 맨 위의 값이 된다.
     * 현재 강의의 시작시간이 수업이 가장 빨리 끝나는 강의실보다 작다는 것은 해당 강의실이 끝나기 전에 강의가 시작된다는 의미이며, 다른 강의실은 이보다 더 이후에 끝나므로
     * 새로운 강의실 즉, 우선순위 큐에 add를 한다.
     * 근데 가장 빨리 끝나는 강의실보다 같거나 크면, 해당 강의실을 그대로 이용하면 되므로 poll하고 add를 하면 된다.
     *
     * 최종적으로 우선순위 큐의 size의 값은 최소한으로 사용된 강의실의 수가 된다.
     */
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sToken;
        int N = Integer.parseInt(br.readLine());
        int[][] studyTimes = new int[N][2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;

        for(int i = 0; i < N; i++) {
            sToken = new StringTokenizer(br.readLine());
            studyTimes[i][0] = Integer.parseInt(sToken.nextToken());
            studyTimes[i][1] = Integer.parseInt(sToken.nextToken());
        }

        Arrays.sort(studyTimes, (int[] o1, int[] o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return  o1[0] - o2[0];
        });

        for(int i = 0; i < N; i++) {
            int preStartTime = studyTimes[i][0];

            if(!pq.isEmpty() && pq.peek() <= preStartTime) {
                //pq에 값이 존재하고, 제일 빨리 끝나는 강의실을보다 같거나 크면 해당 강의실을 그대로 사용한다.
                pq.poll();
                pq.add(studyTimes[i][1]);
            }else {
                //아니라면 새로운 강의실을 사용한다.
                pq.add(studyTimes[i][1]);
            }

        }

        System.out.println(pq.size());

        br.close();
    }


    /**
     * 내가 맞춘 정답
     */
    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sToken;
        int N = Integer.parseInt(br.readLine());
        int[][] studyTimes = new int[N][2];
        int[] studyRooms = new int[N];
        int answer = 0;

        for(int i = 0; i < N; i++) {
            sToken = new StringTokenizer(br.readLine());
            studyTimes[i][0] = Integer.parseInt(sToken.nextToken());
            studyTimes[i][1] = Integer.parseInt(sToken.nextToken());
        }

        Arrays.sort(studyTimes, (int[] o1, int[] o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return  o1[0] - o2[0];
        });

        for(int i = 0; i < N; i++) {
            int preStartTime = studyTimes[i][0];
            for(int j = 0; j < N; j++) {
                if(studyRooms[j] <= preStartTime) {
                    studyRooms[j] = studyTimes[i][1];
                    break;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            if(studyRooms[i] != 0) {
                answer++;
            }
        }

        System.out.println(answer);

        br.close();
    }
}
