package lecture.inflearn.kimtaewon.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


/**
 * 8. 등수구하기
 */
public class Problem02_08 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Student> pq = new PriorityQueue<>();
        int[] answer = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            pq.add(new Student(Integer.parseInt(st.nextToken()), i));
        }

        int currentCount = 2; // 현재 판별할 학생 번호
        int rank = 1; // 현재 학생의 등수 값

        Student frontStudent = pq.poll();
        answer[frontStudent.number] = rank;

        while(!pq.isEmpty()) {
            Student backStudent = pq.poll();

            if(frontStudent.score != backStudent.score) rank = currentCount;

            answer[backStudent.number] = rank;
            frontStudent = backStudent;
            currentCount++;
        }

        for(int i = 1; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }

        br.close();
    }

}

class Student implements Comparable<Student> {
    int score;
    int number;

    public Student(int score, int number) {
        this.score = score;
        this.number = number;
    }

    @Override
    public int compareTo(Student o) {
        return o.score - this.score;
    }
}
