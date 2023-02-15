package baekjoon.bruteforce.silver.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 실버 2
 * N과 M (9)
 *
 * 방법은 2가지로, 하나는 LinkedHashSet을 통해 중복순열을 문자열로 변환 후 Set 특성을 활용해 제거하는 방법이며,
 * 하나는 백트래킹을 활용한 방법이다.
 * 백트래킹 방법은 아래 글을 참고하였다.
 * https://dy-coding.tistory.com/entry/%EB%B0%B1%EC%A4%80-15663%EB%B2%88-N%EA%B3%BC-M-9-java
 *
 * 해당 문제에서 중복 순열을 만들지 않기 위해서는
 * 같은 인덱스에서 같은 숫자를 사용하면 안된다. 만 지키면 된다.
 *
 * 이에 대한 예시는 1 9 9 가 있을 때 2개를 뽑는다고 하면
 * 처음에 1을 뽑고, 두번째를 뽑을때 2번째 인덱스인 9를 뽑을 테고, 이후에 반환.
 * 다음에는 3번째 인덱스인 9를 또 뽑게 된다면, (1,9) (1,9) 가 되므로 중복이 되어버린다.
 *
 * 첫번째 인덱스 값에 대한 순열을 전부 뽑고나서 다음 첫번째 인덱스 값을 위 1 9 9 에서 두번째 인덱스인 9를 사용한다고 하자
 * 그럼 9를 뽑고 이후 재귀함수에 의해 다음 함수의 반복문에서 1을 뽑을 것이다. (9,1)
 * 출력 후 다음 반복문에서 첫번째 인덱스는 사용중이니 넘어가고 이후 3번째 인덱스의 값인 9를 사용할 때에는 before값은 1이므로 사용이 가능하다.
 * 즉 (9,9)를 뽑게 된다.
 *
 * 마지막으로, 첫번재 순열 값을 3번째 인덱스라고 가정하면 또 9를 사용하고자 할텐데
 * 이 때 처음 순열값을 고르는 재귀함수의 before 값은 두번째 인덱스인 9를 가지고 있고 이는 3번째 인덱스와 동일한 값이므로 그냥 넘어가게 된다.
 * 이를 통해 순열의 중복을 배제하면서 뽑을 수 있는 것이다.
 */
public class Problem15663 {

    public static int[] numbers;
    public static int[] permutationNumbers;
    public static boolean[] checkNumbers;
    public static int M;


    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sToken = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(sToken.nextToken());
        M = Integer.parseInt(sToken.nextToken());

        numbers = new int[N];
        checkNumbers = new boolean[N];
        permutationNumbers = new int[M];

        sToken = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(sToken.nextToken());
        }

        Arrays.sort(numbers);

        permutationBacktracking(0);

    }

    public static void permutationBacktracking(int idx) {

        if(idx == M) {
            for (int value : permutationNumbers) {
                System.out.print(value + " ");
            }
            System.out.println();
            return;
        }

        //해당 번째 idx에서 같은 숫자를 또 사용하는지 아닌지를 판단하는 변수
        int before = 0;

        for(int i = 0; i < numbers.length; i++) {
            if(checkNumbers[i]) continue;

            if(before != numbers[i]) {
                before = numbers[i];
                permutationNumbers[idx] = numbers[i];
                checkNumbers[i] = true;
                permutationBacktracking(idx + 1);
                checkNumbers[i] = false;
            }
        }
    }
}
