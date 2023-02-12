package baekjoon.greedy.gold.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 골드 5
 * 전구와 스위치(해결 방법을 찾지 못함, 백준에 정답은 제출하지 않음)
 *
 * https://colin-sh.tistory.com/47 을 참고해서 힌트를 얻고 품
 *
 * 해당 문제의 핵심은 N번째 전구의 스위치를 켜서 N-1번째 전구의 값을 일치시킬 수 있다는 것이다.
 * N-1번째 인덱스의 값이 동일하다면 다음으로, 다르다면 인덱스-1 ~ 인덱스 +1 까지 스위치 연산을 시킨 후
 * 카운트를 1 증가 시킨다.
 * 문제는 첫번째 전구는 이전의 전구가 없어서 스위치 연산을 적용해야하는지, 아닌지를 판단할 수가 없다.
 * 그래서 연산을 적용한 배열과 적용하지 않는 배열 2개로 나뉘어서 각각 판단한 후
 * 두 배열의 스위치 작동 횟수의 최솟값이 정답이 된다.
 * 단, 마지막 인덱스의 값이 맞춰야하는 전구배열의 인덱스와 일치하지 않는다면 -1을 반환하면 된다.
 *
 * 
 * (000, 111) 일 때 -> 1 나와야함
 * (000, 110)과 (000, 011) 일 때 -> 1 나와야 함
 * (00000, 00100) 일 때 2 나와야 함
 * 
 */
public class Problem2138 {

    public static int N;
    public static int answer = Integer.MAX_VALUE;
    public static boolean[] endBulb;

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String startBulbString = br.readLine();
        String endBulbString = br.readLine();

        //처음 전구를 키고 시작하는 배열
        boolean[] startBulbTypeA = new boolean[N];
        
        //처음에 전구를 키고 시작하는 배열
        boolean[] startBulbTypeB = new boolean[N];

        //일치시켜야 하는 전구 배열
        endBulb = new boolean[N];

        for(int i = 0; i < N; i++) {
            startBulbTypeA[i] = startBulbString.charAt(i) == '0' ? false : true;
            startBulbTypeB[i] = startBulbString.charAt(i) == '0' ? false : true;
            endBulb[i] = endBulbString.charAt(i) == '0' ? false : true;
        }

        //첫번째 전구의 스위치를 올린다.
        swap(startBulbTypeA, 0);
        //count가 1인 이유는 첫번째 전구의 스위치를 올렸기 때문
        choice(startBulbTypeA, 1, 1);
        choice(startBulbTypeB, 1, 0);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

        br.close();
    }

    public static void choice(boolean[] targetArray, int index, int count) {
        //배열의 끝까지 순회했을 경우이자, 재귀함수의 종료 조건
        if(N == index) {
            //끝이 일치하지 않는다면 answer값을 변경할 수 없다.
            if(targetArray[index - 1] == endBulb[index -1]) {
                answer = Math.min(answer, count);
            }
            return;
        }

        if(targetArray[index - 1] == endBulb[index - 1]) {
            choice(targetArray, index+1, count);
        }else{
            swap(targetArray, index);
            choice(targetArray, index+1, count+1);
        }
    }

    public static void swap( boolean[] targetArray, int index) {
        for(int i = index - 1; i <= index + 1; i++) {
            if(i >= 0 && i < N) {
                targetArray[i] = !targetArray[i];
            }
        }
    }
}
