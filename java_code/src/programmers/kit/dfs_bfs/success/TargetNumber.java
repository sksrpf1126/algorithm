package programmers.kit.dfs_bfs.success;

/**
 * level 2
 * 타겟 넘버
 *
 * BFS 방식으로는 +와 - 값을 각기 따로 큐에 넣는 방식으로 시도하면 풀릴듯 하다.
 */
public class TargetNumber {

    public static int answer = 0;

    public static void main(String[] args) {
        solution(new int[]{1,1,1,1,1}, 3);
        answer = 0;
        solution(new int[]{4,1,2,1}, 4);
    }

    public static void solution(int[] numbers, int target) {
        dfs(numbers, target, 1, numbers[0]);
        dfs(numbers, target, 1, numbers[0] * -1);
        System.out.println(answer);
    }

    public static void dfs(int[] numbers, int target, int idx, int sum) {

        if(idx == numbers.length) {
            if(sum == target) answer++;
            return;
        }

        dfs(numbers, target, idx + 1, sum + numbers[idx]);
        dfs(numbers, target, idx + 1, sum - numbers[idx]);

    }


}
