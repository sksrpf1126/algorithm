package lecture.inflearn.kimtaewon.section_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 1. 선택 정렬
 *
 * 배열을 선형 탐색하여 최솟값을 찾은 후 배열 제일 맨 앞과 교환
 * 이를 반복
 */
public class Problem06_01 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min, targetIdx;

        for(int i = 0; i < N; i++) {
            min = arr[i];
            targetIdx = i;

            for(int j = i; j < N; j++) {
                if(arr[j] < min) {
                    min = arr[j];
                    targetIdx = j;
                }
            }

            if(targetIdx != i) {
                arr[targetIdx] = arr[i];
                arr[i] = min;
            }
        }

        for(int i : arr) {
            System.out.print(i + " ");
        }


    }


}
