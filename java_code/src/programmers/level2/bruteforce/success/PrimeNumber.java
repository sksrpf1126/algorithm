package programmers.level2.bruteforce.success;

import java.util.HashSet;

/**
 * level 2
 * 소수 찾기
 */
public class PrimeNumber {

    public static char[] charNumber;
    public static StringBuilder permutationStr;
    public static boolean[] visits;
    public static HashSet<Integer> set = new HashSet<>();
    public static int answer = 0;

    public static void main(String[] args) {
        String numbers = "011";

        charNumber = numbers.toCharArray();


        for(int i = 1; i <= numbers.length(); i++) {
            permutationStr = new StringBuilder();
            visits = new boolean[numbers.length()];
            permutation(i, 0);
        }

    }

    public static void permutation(int length, int idx) {
        if(length == idx) {
            String str = String.valueOf(permutationStr);
            if(!set.contains(Integer.parseInt(str))) {
                set.add(Integer.parseInt(str));
                findPrimeNumber(Integer.parseInt(str));
            }
            return;
        }

        for(int i = 0; i < charNumber.length; i++) {
            if(visits[i]) continue;

            visits[i] = true;
            permutationStr.append(charNumber[i]);
            permutation(length, permutationStr.length());
            permutationStr.deleteCharAt(permutationStr.length() - 1);
            visits[i] = false;
        }
    }

    public static void findPrimeNumber(int number) {
        if(number <= 1) return;

        for(int i = 2; i < number; i++) {
            if(number % i == 0) {
                return;
            }
        }
        answer++;
    }
}
