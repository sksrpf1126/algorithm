package baekjoon.bruteforce.silver.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 실버 3
 * 다음 순열
 *
 * 참고 : https://dundung.tistory.com/58
 */
public class Problem10972 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = N;
        StringTokenizer sToken = new StringTokenizer(br.readLine());
        int leftTargetIdx = -1;
        int rightTargetidx = -1;

        int[] targetNumbers = new int[N];

        for(int i = 0; i < N; i++) {
            targetNumbers[i] = Integer.parseInt(sToken.nextToken());
        }

        //i번째보다 i-1번째가 작다면 오름차순이 끝난것으로, 작은값의 인덱스를 넣어둔다.
        for(int i = N - 1; i >= 1; i--) {
            if(targetNumbers[i-1] < targetNumbers[i]){
                leftTargetIdx = i - 1;
                break;
            }
        }

        //leftTargetIdx값이 변하지 않았으면 맨 왼쪽까지 쭉 오름차순으로 다음 순열은 존재하지 않는다.
        if(leftTargetIdx == -1) {
            System.out.println(-1);
            return;
        }

        //leftTargetIdx의 값보다 큰 수들 중 최솟값을 찾는 과정
        for(int i = N - 1; i > leftTargetIdx; i--) {
            if(targetNumbers[leftTargetIdx] < targetNumbers[i]){
                rightTargetidx = i;
                break;
            }
        }

        swap(targetNumbers, leftTargetIdx, rightTargetidx);

        int i = leftTargetIdx + 1;
        int j = targetNumbers.length - 1;

        while (i < j) {
            swap(targetNumbers, i, j);
            i++;
            j--;
        }

        for (int val : targetNumbers) {
            System.out.print(val + " ");
        }

    }

    public static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

}
