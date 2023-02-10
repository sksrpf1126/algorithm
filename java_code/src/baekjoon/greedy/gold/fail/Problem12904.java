package baekjoon.greedy.gold.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 골드 5(실패)
 * A와 B
 *
 * S -> T로 가는 방법으로 생각하다가 결국 풀지 못한 문제이다.
 * S -> T로 가는 것을 판단하기 위해서는 1번 연산과 2번 연산 둘 중에 하나를 해가면서 판단해야 하는데, 이러면 2^T의 시간복잡도가 되어 버린다. (2가지 선택지를 둘 다 적용해 가면서 맞는지 틀린지
 * 판단해야 하기 때문)
 *
 * 해결방법은 S -> T가 아닌 T -> S 가 될 수 있도록 푸는 방법이다.
 * T의 마지막 문자가 A라면 그 이전에 S는 1번 연산을 했다는 의미로, T의 마지막 문자를 제거하면 된다.
 * T의 마지막 문자가 B라면 마지막 문자를 제거한 후 뒤집는다.
 * 이를 S의 문자열 길이와 같아질 때 까지 반복 후 S와 T가 같은지를 판단하면 된다.
 */
public class Problem12904 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer S =new StringBuffer(br.readLine());
        StringBuffer T =new StringBuffer(br.readLine());

        while (T.length() > S.length()) {
            if (T.charAt(T.length() - 1) == 'A') {
                T.deleteCharAt(T.length() - 1);
            }else {
                //B일 수 밖에 없으므로
                T.deleteCharAt(T.length() - 1);
                T = T.reverse();
            }
        }

        if(T.toString().equals(S.toString()) ){
            System.out.println(1);
        }else{
            System.out.println(0);
        }

        br.close();
    }
}
