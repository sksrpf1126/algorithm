package lecture.inflearn.kimtaewon.section_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 3. 최대점수 구하기
 */
public class Problem08_03 {

    static class Test {
        int point;
        int time;

        public Test(int point, int time) {
            this.point = point;
            this.time = time;
        }
    }

    public static int N, M, answer = 0;
    public static boolean[] visits;
    public static Test[] tests;

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tests = new Test[N];
        visits = new boolean[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            tests[i] = new Test(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        dfs(0);

        System.out.println(answer);

        br.close();
    }

    public static void dfs(int count) {
        if(count == N) {
            int totalPoint = 0, totalTime = 0;
            for(int i = 0; i < N; i++) {
                if(visits[i]) {
                    totalPoint += tests[i].point;
                    totalTime += tests[i].time;
                }
            }

            if(totalTime <= M) answer = Math.max(answer, totalPoint);

        }else {
            visits[count] = true;
            dfs(count + 1);

            visits[count] = false;
            dfs(count + 1);
        }
    }


}


