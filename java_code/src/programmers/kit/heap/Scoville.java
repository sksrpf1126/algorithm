package programmers.kit.heap;

import java.util.PriorityQueue;

/**
 * level 2
 * 더 맵게
 */

/**
 * 다른 사람의 풀이 중
 *
 * while(q.size() > 1 && q.peek() < K){
 *             int weakHot = q.poll();
 *             int secondWeakHot = q.poll();
 *
 *             int mixHot = weakHot + (secondWeakHot * 2);
 *             q.add(mixHot);
 *             count++;
 *         }
 *
 * 내가 아래에 while문 안의 if~ break를 위 사람은 while문 안의 조건으로 집어 넣었다.
 */
public class Scoville {
    public static void main(String[] args) {
        int[] scoville = new int[]{4,3,2,2132,13,31,1};
        int k = 7;
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int val : scoville) {
            pq.offer(val);
        }

        int shakeFoodScoville = 0;

        while (!pq.isEmpty()) {

            if(pq.peek() >= k || pq.size() <= 1) {
                break;
            }

            answer++;
            shakeFoodScoville = pq.poll() + (pq.poll() * 2);
            pq.offer(shakeFoodScoville);

        }

        if(pq.size() <= 1 && pq.peek() < k) {
            answer = -1;
        }

//        System.out.println("answer = " + answer);

    }
}
