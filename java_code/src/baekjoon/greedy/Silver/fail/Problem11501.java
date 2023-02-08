package baekjoon.greedy.Silver.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 실버 2
 * 주식 (시간초과)
 *
 * 내가 푼 풀이는 아래와 같이 처음에는 배열전체에서 제일 큰 값을 찾아서 해당 값을 찾을때까지 최대이익을 더한다
 * 제일 큰 값을 만난다면 큰 값 이후의 인덱스부터 맨 끝 인덱스까지 배열을 깊은복사한뒤 정렬 후 최댓값을 갱신시킨다.
 * 이후 복사할배열이 없을때까지 이를 반복한다.
 * 하지만 이는 시간초과를 발생시킨다. sort에만 nlogn이지만, 최악의 경우 n^2까지 발생하므로, 최댓값을 구하는 방식에서 시간초과가 발생한 것이다.
 *
 * while (startIdx < stockPrices.length) {
 *  int[] stockPricesSort = Arrays.copyOfRange(stockPrices, startIdx, stockPrices.length);
 *  Arrays.sort(stockPricesSort);
 *  int max = stockPricesSort[stockPricesSort.length - 1];
 *
 *  for(int j = startIdx; j < stockPrices.length; j++) {
 *
 *      if(stockPrices[j] == max) {
 *         startIdx = j + 1;
 *         break;
 *      }else {
 *         total += max - stockPrices[j];
 *      }
 *
 *  }
 *}
 */
public class Problem11501 {
    public static void main(String[] args) throws IOException {
        solution();

    }

    /**
     * 정렬 필요 없이, 뒤에서부터 검증하는 방식으로, 이전의 값이 현재의 최댓값보다 크면, 최댓값을 갱신하며 최댓값이 계속 갱신이 된다는 의미는 주가는 계속  하락세를 의미 즉 최대 이익은 더할 필요가 없다.
     * 반대로 최댓값이 갱신 안되는 시점부터 현재 최댓값보다 큰 값을 만나기 전까지는 주가가 상승세라는 의미로, 최대 이익을 계산한다.
     * answer은 long타입이어야 함
     */
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());
        StringTokenizer sToken;

        for(int i = 0; i < testCaseCount; i++) {
            int days = Integer.parseInt(br.readLine());
            sToken = new StringTokenizer(br.readLine());

            int[] stockPrices = new int[days];
            //주가 배열 할당
            for(int j = 0; j < stockPrices.length; j++) {
                stockPrices[j] = Integer.parseInt(sToken.nextToken());
            }
            
            long answer = 0;
            int max = stockPrices[stockPrices.length - 1];
            
            //O(n) 복잡도
            for(int j = stockPrices.length - 2; j >= 0; j--) {
                if(stockPrices[j] >= max) {
                    max = stockPrices[j];
                }else {
                    answer += max - stockPrices[j];
                }
            }
            
            System.out.println(answer);
        }


        br.close();
    }
}
