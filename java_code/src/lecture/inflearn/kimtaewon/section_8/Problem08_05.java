package lecture.inflearn.kimtaewon.section_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * 5. 동전교환
 */
public class Problem08_05 {

    public static int N, target, answer = Integer.MAX_VALUE;
    public static Integer[] numbers;

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        numbers = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        target = Integer.parseInt(br.readLine());

        Arrays.sort(numbers, Collections.reverseOrder());

        dfs_2(0, 0);

        System.out.println(answer);

        br.close();
    }

    public static void dfs_2(int sum, int count) {
        if(sum > target) return;
        if(count >= answer) return;
        if(sum == target) {
            answer = count; // Math.min(answer, count) 와 동일
        }else {
            for(int n : numbers) {
                dfs_2(sum + n, count + 1);
            }
        }
    }

    /**
     * 내가 푼 방법으로 이러면 반복 횟수가 많아져 time limit 발생
     * 나의 경우 count가 answer보다 큰 상태여도 target값과 일치하는 sum값을 찾을려고 반복하지만
     * 위 강사님의 방법은 count가 answer보다 큰 상태라면 반복을 하지 않으므로 시간 초과 발생을 하지 않음
     */
    public static void dfs(int sum, int count) {
        if(sum == target) {
            answer = Math.min(answer, count);
            return;
        }

        for(int n : numbers) {
            if(sum + n > target) continue;
            if(count >= answer) continue;

            dfs(sum + n, count + 1);
        }

    }


}


