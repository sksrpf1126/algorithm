package lecture.inflearn.kimtaewon.section_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * 8. 응급실
 */
public class Problem05_08 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int target = 0, answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Person> q = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            Integer value = Integer.valueOf(st.nextToken());
            q.add(new Person(value, i));
            pq.offer(value);

            if(M == i) target = value;
        }

        int high = pq.poll();

        while(!q.isEmpty()) {
            Person person = q.poll();

            if(person.score == target && person.score == high && person.order == M) {
                answer++;
                break;
            }else if(person.score == high) {
                high = pq.poll();
                answer++;
            }else {
                q.offer(person);
            }

        }

        System.out.println(answer);

    }

}

class Person {
    int score;
    int order;

    public Person(int score, int order) {
        this.score = score;
        this.order = order;
    }
}
