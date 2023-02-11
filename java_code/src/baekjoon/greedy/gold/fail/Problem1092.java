package baekjoon.greedy.gold.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 골드 5
 * 배 (시간 초과로 인한 실패)
 *
 * 크레인과 박스를 내림차순으로 정렬시켜서 접근하는 알고리즘은 맞는 방법이었지만 시간 복잡도에 의해서 시간초과가 발생하였다.
 * 나는 우선순위 큐를 2개 선언하여 처음 크레인으로 옮기는 작업에서 못 옮기는 박스들은 나머지 하나의 큐에 담았다가 한번의 반복문이 끝나면 작업 대상의 큐에 addAll을 수행하고
 * 못 옮기는 박스들을 담는 큐를 clear 시키는 로직으로 접근했다.
 * 크레인 옮기는 내부 for문에서는 최악의 가정하에
 * 문제는 addAll 과정에서 log N의 추가를 N번만큼 반복한다는 것이다. 즉 NlogN을 수행하며 while문은
 *
 */
public class Problem1092 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] crane = new Integer[N];
//        PriorityQueue<Integer> boxes = new PriorityQueue<>(Comparator.reverseOrder());
//        PriorityQueue<Integer> boxesCopy = new PriorityQueue<>(Comparator.reverseOrder());
        ArrayList<Integer> boxes = new ArrayList<>();
        int answer = 0;
        StringTokenizer sToken = new StringTokenizer(br.readLine());


        //크레인 할당
        for(int i = 0; i < N; i++) {
            crane[i] = Integer.parseInt(sToken.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        sToken = new StringTokenizer(br.readLine());

        //박스 할당
        for(int i = 0; i < M; i++) {
            boxes.add(Integer.valueOf(sToken.nextToken()));
        }

        Arrays.sort(crane, Collections.reverseOrder());
        boxes.sort(Comparator.reverseOrder());

        //가장 힘이 강한 크레인이 가장 무거운 박스를 들지 못한다면 모든 박스를 옮길 수 없음
        if(crane[0] < boxes.get(0)) {
            System.out.println(-1);
            return;
        }

        while (boxes.size() != 0) {
            int idx = 0;
            for(int i = 0; i < crane.length; i++) {
                //boxes.size() == idx 하나로 줄일 수 있지만 직관성을 위해서..
                if(boxes.size() == 0 || boxes.size() == idx) {
                    break;
                }else if(crane[i] >= boxes.get(idx)) {
                    boxes.remove(idx);
                }else {
                    idx++;
                    i--;
                }
            }
            answer++;
        }

        System.out.println(answer);

        br.close();
    }

}
