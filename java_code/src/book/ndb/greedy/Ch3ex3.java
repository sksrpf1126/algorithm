package book.ndb.greedy;

import sortalgorithm.HeapSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 숫자 카드 게임
 */
public class Ch3ex3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.printf("배열 행, 배열 열 ");
        String[] s = br.readLine().split(" ");
        int row = Integer.parseInt(s[0]);
        int column = Integer.parseInt(s[1]);
        int result = 10001;



        for(int i = 0; i < row; i++) {
            int[] array = new int[column];

            String[] arrayNumber = br.readLine().split(" ");
            for(int j = 0; j < column; j++) {
                array[j] = Integer.parseInt(arrayNumber[j]);
            }
            Arrays.sort(array);

            if(i == 0 && result > array[0]) {
                result = array[0];
            }else if(result < array[0]) {
                result = array[0];
            }


        }


        System.out.println("result = " + result);


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
