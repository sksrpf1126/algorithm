package programmers.kit.stackandqueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * level 2
 * 기능개발
 */
public class FunDev {
    public static void main(String[] args) {
        int[] progresses = {95,90,99,99,80,99};
        int[] speeds = {1, 1,1,1,1,1};

        int[] answer = {};

        int days = 0;
        int count = 1;
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < progresses.length; i++) {
            days = (100 - progresses[i]) / speeds[i];

            if((100 - progresses[i]) % speeds[i] != 0) {
                days += 1;
            }

            queue.offer(days);
        }

        Integer target = queue.poll();
        List<Integer> tempList = new ArrayList();
        int afterValue = 0;

        for (int i = queue.size(); i > 0; i--) {
            afterValue = queue.poll();
            if(target >= afterValue) {
                count++;
            }

            if(target < afterValue){
                tempList.add(count);
                target = afterValue;
                count = 1;
            }
        }

        tempList.add(count);

        answer = new int[tempList.size()];

        for(int i = 0; i < tempList.size(); i++) {
            answer[i] = tempList.get(i);
        }

        for (int i : answer) {
            System.out.print(i + " ");
        }


    }
}

/**
 * 다른 분의 풀이
 * 
 * Math.ceil() -> 올림해서 정수 반환
 * 
 * for (int i = 0; i < speeds.length; i++) {
 *             double remain = (100 - progresses[i]) / (double) speeds[i];
 *             int date = (int) Math.ceil(remain);
 *
 *             if (!q.isEmpty() && q.peek() < date) {
 *                 answerList.add(q.size());
 *                 q.clear();
 *             }
 *
 *             q.offer(date);
 *         }
 *
 *         answerList.add(q.size());
 *
 *         int[] answer = new int[answerList.size()];
 *
 *         for (int i = 0; i < answer.length; i++) {
 *             answer[i] = answerList.get(i);
 *         }
 */
