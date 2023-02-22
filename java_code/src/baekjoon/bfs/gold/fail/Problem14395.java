package baekjoon.bfs.gold.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 골드 5
 * 4연산 (실패)
 *
 * 참고 : https://laugh4mile.tistory.com/82
 *
 * 아래는 내가 푼 방식인데, 그대로 남겨두었다.
 *
 */
public class Problem14395 {

    static class Step implements Comparable<Step> {

        private long number;
        private int count;
        private String str;

        public long getNumber() {
            return number;
        }

        public int getCount() {
            return count;
        }

        public String getStr() {
            return str;
        }

        public Step(long number, int count, String str) {
            this.number = number;
            this.count = count;
            this.str = str;
        }

        @Override
        public int compareTo(Step o) {
            return this.count - o.count;
        }
    }

    public static PriorityQueue<Step> pq = new PriorityQueue<>();
    public static PriorityQueue<String> orderString = new PriorityQueue<>();
    public static long s,t;
    public static Set<Long> list = new HashSet<>();

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Long.parseLong(st.nextToken());
        t = Long.parseLong(st.nextToken());

        if(s == t){
            System.out.println(0);
        }else if(t % s != 0 && t % 2 != 0 && t != 1) {
            System.out.println(-1);
        }else {
            bfs();
        }

    }

    public static void bfs() {
        pq.offer(new Step(s, 0, ""));
        list.add(s);
        //1에서 시작하는 경로는 한번이면 됨
        boolean oneStart = false;

        while (!pq.isEmpty()){
            Step current = pq.poll();

            if(current.getNumber() == t) {
                orderString.offer(current.getStr());
                while (!pq.isEmpty() && (pq.peek().getCount() == current.getCount())){
                    Step target = pq.poll();
                    if(target.getNumber() == t){
                        orderString.offer(target.getStr());
                    }
                }
                System.out.println(orderString.poll());
                return;
            }

            if(current.getNumber() == 0) continue;

            if(current.getNumber() * current.getNumber() <= t && !list.contains(current.getNumber() * current.getNumber())) {
                pq.offer(new Step(current.getNumber() * current.getNumber(), current.getCount() + 1, current.getStr() + "*"));
                list.add(current.getNumber() * current.getNumber());
            }

            if(current.getNumber() + current.getNumber() <= t && !list.contains(current.getNumber() + current.getNumber())){
                pq.offer(new Step(current.getNumber() + current.getNumber(), current.getCount() + 1, current.getStr() + "+"));
                list.add(current.getNumber() + current.getNumber());
            }

            if(!oneStart) {
                oneStart = true;
                pq.offer(new Step(current.getNumber() / current.getNumber(), current.getCount() + 1, current.getStr() + "/"));
            }

        }
    }


}
