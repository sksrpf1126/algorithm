package programmers.level4.greedy.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 레벨 4
 * 무지의 먹방 라이브
 * 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/42891
 */
public class MuziEatingLive {
    public static void main(String[] args) throws IOException {
        solution();

    }

    public static void solution() throws IOException {
        int[] food_times = new int[]{3,1,2};
        long k = 5;
        int answer = 0;
        long total = 0;

        for(int i = 0; i < food_times.length; i++) {
            total += food_times[i];
        }

        if(total <= k) {
            System.out.println(-1);
        }

        PriorityQueue<Food> pqFood = new PriorityQueue<>();

        //O(n)
        for(int i = 0; i < food_times.length; i++) {
            pqFood.offer(new Food(food_times[i], i + 1));
        }

        //이전까지의 모든 음식을 먹은 시간
        int sumTime = 0;
        //이전 음식을 전부 먹는데 든 시간
        int preFoodTime = 0;
        //남아있는 음식의 수
        int foodQuantity = food_times.length;


        /**
         * 음식의 time값 즉, 음식을 다 먹는데 적은 시간순으로 정렬되어 있는 pqFood와 이전 음식을 먹는데 걸리는 시간인 preFoodTime
         * sumTime은 해당 음식을 먹기 전 이전음식들을 먹은 시간들의 합
         * foodQuantity는 남아있는 음식의 수이다.
         *
         * 괄호 먼저 계산이 되며, pqFood.peek().getTime() - preFoodTime 은 예시로 들면
         * 가장 작은 음식의 시간이 2이고 그 다음 음식의 시간이 3이라면
         * 가장 작은 음식을 대상으로 연산이 수행되며, 이때 가장 작은 음식을 다먹기 위해서는 2바퀴를 돌아야 한다. 즉, 현재 먹는 음식의 시간은 이전 음식의 시간만큼 뺀 뒤에 남은 시간이
         * 현재 음식을 먹는데 필요한 시간이 된다는 것이다. (앞에서 2를 다 먹는다면, 뒤 3은 3-2 즉, 1만큼의 음식 먹는 시간이 남아 있을 것이다)
         *
         * 다음 foodQuantity 를 곱하는데, 남아있는 음식의 수만큼 돌고나서 해당 음식을 먹게 되므로, 그 수만큼 곱해준다.
         *
         * 마지막으로 이전까지 먹은 음식의 시간과 합을 하며, 이에 대한 값이 k보다 커진다는 의미는 해당 음식을 다 먹기도 전에 네트워크 장애가 발생했다는 의미이며
         * 이보다 작거나 같다는 것은 네트워크 장애가 발생하기 전에 해당 음식을 먹을 수 있다는 의미가 되므로, 반복문을 수행한다.
         *
         * 최악의 경우에는 마지막 음식까지 판단할 수 있으므로, 시간 복잡도는 O(n)
         */
        while (sumTime + (pqFood.peek().getTime() - preFoodTime) * foodQuantity <= k) {
            //네트워크 장애가 발생하기 전에 해당 음식은 전부 먹을 수 있으므로, 해당 음식을 빼낸다.
            Food currentFood = pqFood.poll();
            //해당 음식을 먹은 시간만큼 sumTime에 합을 해준다.
            sumTime += (currentFood.getTime() - preFoodTime) * foodQuantity;
            //이전음식의 시간을 앞으로 한칸 이동시킨다.
            preFoodTime = currentFood.getTime();
            //음식을 다 먹었으므로, 길이를 하나 빼준다.
            foodQuantity -= 1;
        }

        ArrayList<Food> foodSort = new ArrayList<>();

        //O(n)
        while (!pqFood.isEmpty()){
            foodSort.add(pqFood.poll());
        }

        //idx 순으로 정렬
        Collections.sort(foodSort, (Food currentFood, Food otherFood) -> {
            return currentFood.getIdx() - otherFood.getIdx();
        });


        //sumTime의 값은 다 먹은 음식들의 시간값만 가지게 된다.
        //k - sumTime을 하면,다 먹은 음식들의 시간 총합을 뺀 네트워크 지연까지의 남은 시간이 된다.
        //이를 남은음식 수의 나머지를 구하면 해당 음식의 인덱스가 정답이 된다.
        answer = foodSort.get((int)(k - sumTime) % foodQuantity).getIdx();
        
        System.out.println("answer : " + answer);

    }
}

class Food implements Comparable<Food> {
    private int time;
    private int idx;

    public Food(int time, int idx) {
        this.time = time;
        this.idx = idx;
    }

    public int getTime() {
        return time;
    }

    public int getIdx() {
        return idx;
    }

    //시간순으로 정렬
    @Override
    public int compareTo(Food order) {
        return this.time - order.time;
    }
}
