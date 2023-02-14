package algorithm;

import java.util.Arrays;

/**
 * 조합 구현
 */
public class Combination {
    public static int[] numbers;
    public static int[] combinationNumbers;
    public static int N, R = 2;
    public static void main(String[] args) {
        numbers = new int[]{1,2,3,4};
        N = numbers.length;
        combinationNumbers = new int[R];

        combinationMethod(0,0);

    }

    public static void combinationMethod(int cnt, int start) {

        if(cnt == R) {
            System.out.println(Arrays.toString(combinationNumbers));
            return;
        }

        for(int i = start; i < N; i++) {
            combinationNumbers[cnt] = numbers[i];
            combinationMethod(cnt + 1, i + 1);
        }
    }
}
