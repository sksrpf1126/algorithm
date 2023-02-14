package algorithm;

import java.util.Arrays;

/**
 * 순열 알고리즘 구현
 * 구현 방법에는 총 2가지로, boolean 배열을 통해 사용한 숫자를 검증하는 방법과, 비트를 활용하여 검증하는 방법으로 나뉜다.
 *
 * 중복 순열 추가 -> 메서드 명 duplicatePermutation
 *
 * https://namhandong.tistory.com/191 글을 참고하였음
 * 
 */
public class Permutation {

    public static int[] permutationNumbers;
    public static int[] numbers;
    public static boolean[] useNumberYn;
    public static int R; //데이터 N개 중에 R개의 데이터로 순열 만들 때 해당 R의 값

    public static void main(String[] args) {
        numbers = new int[]{1,2,3};
        R = numbers.length - 1;
        permutationNumbers = new int[R];
        useNumberYn = new boolean[numbers.length];

        duplicatePermutationBoolean(0);
//        permutationBoolean(0);
//        permutationBitMask(0,0);
    }

    /**
     * 중복 순열은 해당 숫자를 사용했다는 체크가 필요 없다.
     */
    public static void duplicatePermutationBoolean(int idx) {

        //재귀함수 종료 조건
        if(idx == R) {
            System.out.println(Arrays.toString(permutationNumbers));
            return;
        }

        for(int i = 0; i < numbers.length; i++) {
//            if(useNumberYn[i]) continue; 필요 X

            permutationNumbers[idx] = numbers[i];
//            useNumberYn[i] = true;
            duplicatePermutationBoolean(idx + 1);
//            useNumberYn[i] = false;
        }
    }

    /**
     * boolean 배열을 통한 순열 배열 출력
     * @param idx 다음에 값이 들어갈 인덱스
     */
    public static void permutationBoolean(int idx) {

        //재귀함수 종료 조건
        if(idx == R) {
            System.out.println(Arrays.toString(permutationNumbers));
            return;
        }

        for(int i = 0; i < numbers.length; i++) {
            //해당 인덱스의 숫자를 사용 중이라면 continue;
            if(useNumberYn[i]) continue;

            permutationNumbers[idx] = numbers[i];
            useNumberYn[i] = true;
            permutationBoolean(idx + 1);
            useNumberYn[i] = false;
        }
    }

    /**
     * Bit를 통해 값의 사용 여부를 확인하여 순열 배열 출력
     * @param idx
     * @param flag
     */
    public static void permutationBitMask(int idx, int flag) {

        if(idx == R) {
            System.out.println(Arrays.toString(permutationNumbers));
            return;
        }

        for(int i = 0; i < numbers.length; i++) {
            //1을 i만큼 옮기고 오른쪽은 0으로 채워짐
            //즉, i번째 만큼 옮겨서 and연산을 햇을 때 1이라는 의미(0이 아니라면)는 해당 i번째 숫자를 사용중이라는 의미
            if((flag & 1 << i) != 0) continue;

            permutationNumbers[idx] = numbers[i];
            permutationBitMask(idx + 1, flag | 1 << i);
        }

    }
}
