package baekjoon.greedy.gold.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 골드 5
 * 센서(실패 - 솔루션 찾기 실패)
 *
 * 솔루션의 실마리를 찾을려고 하다보니 점점 복잡해지기만 하고, 시간만 소비하였다.
 * 결국 블로그 글을 보고 이해를 하였음.
 * https://dy-coding.tistory.com/entry/%EB%B0%B1%EC%A4%80-2212%EB%B2%88-%EC%84%BC%EC%84%9C-java
 *
 * 핵심은 센서 수 N과 기지국 수 K가 있을 때 포함해야할 간격의 수는 N - K 라는 것이다.
 * 예를 들어 예제 1번인 N = 6, K = 2이며 센서의 좌표는 (1,6,9,3,6,7) 정렬 시 -> (1,3,6,6,7,9) 이면
 * 기지국 수는 2개 이며, 최소 값을 만들기 위해서는 모든 기지국을 활용하는 것이 당연하다.
 * 즉, 기지국 수 2개를 활용하면 최소 하나의 센서를 가지게 되며, A범위(긴격)의 기지국과 B범위(간격)의 기지국 사이의 범위(간격)은 계산할 필요가 없다.
 * (1,3,6,6,7,9) 에서의 간격은 1-3 3-6 6-6 6-7 7-9 총 5개의 간격의 수를 가지며 (1,3)을 기지국 하나가 가지고, (6,6,7,9)를 기지국 하나가 가지게 된다면
 * 1-3 1개
 * 6-6 6-7 7-9 3개
 * 총 4개를 가지게 되며 3-6은 두 기지국 사이의 간격이므로 포함시키지 않는다.
 * 하나의 간격을 기지국의 범위를 어떻게 정하냐에 따라 배제시킬 수 있으며, 문제는 최소값의 거리를 구하는 것이 목적이므로, 가장 큰 간격을 배제시키는 것이 해답이 된다.
 *
 * 5개의 간격의 차를 구하면 (2,3,0,1,2) 가 되며, 여기서 최소값을 얻기 위해서는 제일 큰 간격인 3을 배제시키고 나머지를 합하는 것이 해답이다.
 *
 * 만약 15개의 센서와 5개의 기지국이 존재한다면, 포함시켜야 할 간격의 수는 15 - 5 즉, 10개이며 반대로 배제시킬 수 있는 간격의 수는 총 간격의 수(N-1) - 포함시켜야 할 간격의 수(N-K)
 * 즉, (N-1) - (N-K) 의 값만큼 배제시킬 수 있다.
 */
public class Problem2212 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        StringTokenizer sToken = new StringTokenizer(br.readLine());
        Integer[] sensorPos = new Integer[N];
        Integer[] diff = new Integer[N-1]; //센서의 수가 N개일 때 간격의 수는 N-1개이다.
        Integer answer = 0;

        //기지국의 수가 센서수보다 같거나 클 경우 0을 반환
        if(N <= K) {
            System.out.println(0);
            return;
        }

        //센서 좌표 배열 넣기
        for(int i = 0; sToken.hasMoreTokens(); i++) {
            sensorPos[i] = Integer.parseInt(sToken.nextToken());
        }

        //센서좌표 오름차순으로 정렬
        Arrays.sort(sensorPos);

        for(int i = 1; i < sensorPos.length; i++) {
            diff[i-1] = sensorPos[i] - sensorPos[i-1];
        }

        //원시 타입(int, long, double 은 Collections.reverseOrder() 사용 불가 compare 익명 객체 만들어 줘야함
        Arrays.sort(diff, Collections.reverseOrder());

        for(int i = (N-1) - (N-K); i < diff.length; i++) {
            answer += diff[i];
        }

        System.out.println(answer);

    }
}
