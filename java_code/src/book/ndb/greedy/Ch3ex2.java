package book.ndb.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 큰 수의 법칙
 */
public class Ch3ex2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.printf("배열 길이, 덧셈 횟수, 연속 덧셈 제한 수 ");
        String[] s = br.readLine().split(" ");
        int len = Integer.parseInt(s[0]);
        int sumCount = Integer.parseInt(s[1]);
        int limit = Integer.parseInt(s[2]);


        String[] arrayNumber = br.readLine().split(" ");
        int[] array = new int[len];

        for(int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(arrayNumber[i]);
        }

        Arrays.sort(array);

        int first = array[array.length - 1];
        int second = array[array.length - 2];

        int count = (sumCount / (limit + 1)) * limit;
        count += sumCount % (limit + 1);

        int total = count * first;
        total += (sumCount - count) * second;

        System.out.println("total = " + total);


    }
}
/**
 * 내 풀이
 *  Arrays.sort(array);
 *
 *         int total = 0;
 *         int limitCount = 0;
 *
 *         for(int i = 1; i <= sumCount; i++) {
 *
 *             if(limitCount < limit) {
 *                 total += array[array.length - 1];
 *                 limitCount++;
 *             }else {
 *                 total += array[array.length - 2];
 *                 limitCount = 0;
 *             }
 *         }
 */
