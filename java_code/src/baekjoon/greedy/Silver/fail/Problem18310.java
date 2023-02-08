package baekjoon.greedy.Silver.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 실버 3
 * 안테나 (해결하지 못한 문제)
 * 처음에 생각한 방법은 이중 for문을 활용한 방법이지만 해당 방법으로는 O(n^2) 시간복잡도에 의해 시간초과가 발생한다.
 * 이후, 방법이 생각나지 않아 해결방법을 참고하였음
 * 쭝간값을 활용한 방법으로, 맨 왼쪽에서 오른쪽으로 갈 경우 지나친 집들(왼쪽에 위치한 집들)과 지나치지 않은 집들(오른쪽에 위치한 집들)을 기준으로 생각해보면
 * 지나친 집들로부터는 점점 거리가 멀어질테고, 지나치지 않은 집들을 대상으로는 거리가 좁혀질 것이다.
 * 그러면 오른쪽 집이 더 많은 경우에는 계속해서 오른쪽으로 가는 것이 거리의 총합을 기준으로 생각할 때는 작아진다.
 * 반대로, 왼쪽 집이 많아질 시점에서는 오른쪽으로 이동할 수록 총합은 증가한다.
 *
 * 그럼 왼쪽집과 오른쪽 집의 수가 동일하거나, 왼쪽집이 많아지는 시점의 이전 집이 안테나를 설치하기에 적합하다는 것이다.
 */
public class Problem18310 {
    public static void main(String[] args) throws IOException {
        solution();

    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int houseCount = Integer.parseInt(br.readLine());
        StringTokenizer sToken = new StringTokenizer(br.readLine());
        int[] housePosition = new int[houseCount];

        for(int i = 0; i < houseCount; i++) {
            housePosition[i] = Integer.parseInt(sToken.nextToken());
        }

        Arrays.sort(housePosition);

        //1개라면 바로 반환
        if(housePosition.length == 1) {
            System.out.println(housePosition[0]);
            return;
        }
        
        //왼쪽 집의 수 => 현재 인덱스 값
        //오른쪽 집의 수 => (배열길이 - 1) - 현재 인덱스
        for(int i = 0; i < housePosition.length; i++) {
            if(i > (housePosition.length - 1) - i) {
                System.out.println(housePosition[i - 1]);
                break;
            }
        }
        
        br.close();
    }
}
