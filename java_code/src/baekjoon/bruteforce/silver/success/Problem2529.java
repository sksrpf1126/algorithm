package baekjoon.bruteforce.silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 실버 1
 * 링크와 스타트
 *
 * MIN값을  Integer.MAX_VALUE 로 잘못 생각하고 초기화 해서 반례도움을 받은 문제
 * 최솟값이 int형의 최댓값보다 클 수 있으므로, Long 타입의 최댓값으로 초기화를 하는게 맞다...
 *
 */
public class Problem2529 {
    public static int K;
    public static int[] numbers = new int[]{0,1,2,3,4,5,6,7,8,9};
    public static int[] permutationNumbers;
    public static char[] signs;
    public static long MAX = 0;
    public static long MIN = Long.MAX_VALUE;
    public static boolean[] visits;

    public static void main(String[] args) throws IOException {
        solution();

    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        visits = new boolean[10];
        signs = new char[K];
        permutationNumbers = new int[K + 1];

        StringTokenizer sToken = new StringTokenizer(br.readLine());

        for(int i = 0; i < K; i++) {
            signs[i] = sToken.nextToken().charAt(0);
        }

        permutation(0);

        System.out.println(MAX);

        String min = String.valueOf(MIN);

        if(min.length() < K + 1) {
            min = "0" + min;
        }

        System.out.println(min);


    }

    public static void permutation(int idx) {
        if(idx == K + 1) {
            compareNumber();
            return;
        }

        for(int i = 0; i < numbers.length; i++) {
            if(visits[i]) continue;

            permutationNumbers[idx] = numbers[i];
            visits[i] = true;
            permutation(idx + 1);
            visits[i] = false;

        }
    }

    public static void compareNumber() {
        boolean numberCombiOk = true;

        for(int i = 0; i + 1 < permutationNumbers.length; i++) {
            if(signs[i] == '>') {
                if(permutationNumbers[i] <= permutationNumbers[i + 1]){
                    numberCombiOk = false;
                    break;
                }
            }else if(signs[i] == '<') {
                if(permutationNumbers[i] >= permutationNumbers[i + 1]) {
                    numberCombiOk = false;
                    break;
                }
            }
        }

        if(!numberCombiOk) {
            return;
        }

        String str = "";

        for (int number : permutationNumbers) {
            str += number;
        }

        MAX = Math.max(MAX, Long.parseLong(str));
        MIN = Math.min(MIN, Long.parseLong(str));

    }

}
