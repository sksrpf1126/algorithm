package programmers.kit.dfs_bfs.success;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * level 3
 * 여행 경로
 *
 * 나는 우선순위 큐에 정렬조건을 추가하여서 풀었지만, Stack으로 푸신 분들도 보인다.
 */
public class TravelPath {

    public static PriorityQueue<String[]> pq = new PriorityQueue<>(new Comparator<String[]>() {
        @Override
        public int compare(String[] o1, String[] o2) {

            for(int i = 0; i < o1.length; i++) {
                if(!o1[i].equals(o2[i])) return o1[i].compareTo(o2[i]);
            }

            return o1[0].compareTo(o2[0]);
        }
    });

    public static boolean[] visits;

    public static void main(String[] args) {
//        solution(new String[][]{{"ICN", "JFK"},{"HND","IAD"},{"JFK", "HND"}});
        System.out.println();
        pq.clear();
        solution(new String[][]{{"ICN", "SFO"},{"ICN", "ATL"},{"SFO", "ATL"},{"ATL", "ICN"},{"ATL","SFO"}});
    }

    public static void solution(String[][] tickets) {
        visits = new boolean[tickets.length];

        ArrayList<String> list = new ArrayList<>();
        list.add("ICN");

        dfs(tickets, "ICN", list);

        String[] answer = pq.poll();

        for (String s : answer) {
            System.out.print(s + " ");
        }
    }

    public static void dfs(String[][] tickets, String target, ArrayList<String> list) {

        if (list.size() == tickets.length + 1) {
            String[] strArr = new String[list.size()];
            for(int i = 0; i < list.size(); i++) {
                strArr[i] = list.get(i);
            }
            pq.offer(strArr);
            return;
        }

        for(int i = 0; i < tickets.length; i++) {
            if(visits[i]) continue;

            if(tickets[i][0].equals(target)) {
                visits[i] = true;
                list.add(tickets[i][1]);
                dfs(tickets, tickets[i][1], list);
                list.remove(list.size() - 1);
                visits[i] = false;
            }
        }
    }


}
